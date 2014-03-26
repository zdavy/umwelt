package umwelt.server.Handlers;

import umwelt.server.Requests.iRequest;
import umwelt.server.Responses.iResponse;
import umwelt.server.Routers.iRouter;
import umwelt.server.Sockets.ServerSocket.iServerSocket;
import umwelt.server.Sockets.Socket.iSocket;
import umwelt.server.Utils.iParser;

public class Handler implements iHandler {
  private  iServerSocket empfanger;
  private  iSocket volksempfanger;
  private  iRouter router;
  private  iParser parser;

  public Handler(iServerSocket empfanger, iRouter router, iParser parser) {
    this.empfanger = empfanger;
    this.parser = parser;
    this.router = router;
  }

  public void start() throws Exception {
    while(empfanger.isOpen()) {
      volksempfanger = empfanger.listen();
      interact(volksempfanger);
    }
  }

  public void interact(iSocket volksempfanger) throws Exception {
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
