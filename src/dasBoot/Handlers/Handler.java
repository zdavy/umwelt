package dasBoot.Handlers;

import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;
import dasBoot.Routers.iRouter;
import dasBoot.Sockets.ServerSocket.iServerSocket;
import dasBoot.Sockets.Socket.iSocket;
import dasBoot.Utils.iParser;

public class Handler implements iHandler {
  private  iServerSocket empfanger;
  private  iRouter router;
  private  iParser parser;

  public Handler(iServerSocket empfanger, iRouter router, iParser parser) {
    this.empfanger = empfanger;
    this.parser = parser;
    this.router = router;
  }

  public void start() throws Exception {
    while(empfanger.isOpen()) {
      interact(empfanger.listen());
    }
  }

  private void interact(iSocket volksempfanger) throws Exception {
    try {
      iRequest request = volksempfanger.request(parser);
      iResponse response = router.route(request);
      volksempfanger.respondWith(response);
      volksempfanger.close();
    } catch (Exception e) {
      volksempfanger.close();
    }
  }
}
