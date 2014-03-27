package dasBoot.server.Handlers;

import dasBoot.server.Requests.iRequest;
import dasBoot.server.Responses.iResponse;
import dasBoot.server.Routers.iRouter;
import dasBoot.server.Sockets.ServerSocket.iServerSocket;
import dasBoot.server.Sockets.Socket.iSocket;
import dasBoot.server.Utils.iParser;

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
