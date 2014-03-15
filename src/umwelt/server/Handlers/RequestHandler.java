package umwelt.server.Handlers;

import java.io.IOException;

import umwelt.server.Communication.UmweltRequest;
import umwelt.server.Communication.UmweltResponse;
import umwelt.server.Routers.iRouter;
import umwelt.server.Sockets.iSocket;
import umwelt.server.Sockets.iServerSocket;

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
      UmweltResponse response = routeHandler.delegate(request);
      clientSocket.respondWith(response);
      clientSocket.close();
  }
}
