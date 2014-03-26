/* src.umwelt.test.Handlers.RequestHandlerTest */
package umwelt.server.Handlers;

import umwelt.server.Requests.UmweltRequest;
import umwelt.server.Responses.iResponse;
import umwelt.server.Routers.iRouter;
import umwelt.server.Sockets.Client.iSocket;
import umwelt.server.Sockets.Server.iServerSocket;

public class UmweltHandler {
  public  iServerSocket serverSocket;
  public  iSocket       clientSocket;
  public  iRouter  router;

  public UmweltHandler(iServerSocket serverSocket, iRouter router) {
    this.router = router;
    this.serverSocket = serverSocket;
  }

  public void start() throws Exception {
    while(serverSocket.isOpen()) {
      clientSocket = serverSocket.listen();
      interact(clientSocket);
    }
  }

  public void interact(iSocket clientSocket) throws Exception {
    try {
      UmweltRequest request = clientSocket.request();
      iResponse response = router.route(request);
      clientSocket.respondWith(response);
      clientSocket.close();
    } catch (Exception e) {
    clientSocket.close();
    }
  }
}
