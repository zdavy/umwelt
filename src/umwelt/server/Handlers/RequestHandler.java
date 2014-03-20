/* src.umwelt.test.Handlers.RequestHandlerTest */
package umwelt.server.Handlers;

import java.io.IOException;

import umwelt.server.Communication.Requests.UmweltRequest;
import umwelt.server.Communication.Responses.iResponse;
import umwelt.server.Routers.iRouter;
import umwelt.server.Sockets.Client.iSocket;
import umwelt.server.Sockets.Server.iServerSocket;

public class RequestHandler {
  private iServerSocket serverSocket;
  public  iSocket       clientSocket;
  private RouteHandler  routeHandler;

  public RequestHandler(iServerSocket serverSocket, iRouter router) {
    routeHandler = new RouteHandler(router);
    this.serverSocket = serverSocket;
  }

  public void start() throws IOException {
    while(serverSocket.isOpen()){
      clientSocket = serverSocket.listen();
      interact(clientSocket);
    }
  }

  public void interact(iSocket clientSocket) throws IOException {
      UmweltRequest request = clientSocket.request();
      iResponse response = routeHandler.delegate(request);
      clientSocket.respondWith(response);
      clientSocket.close();
  }
}
