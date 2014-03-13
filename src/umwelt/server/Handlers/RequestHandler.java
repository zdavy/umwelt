package umwelt.server.Handlers;
/* Request Handler  */
import umwelt.server.Routers.iRouter;
import umwelt.server.Sockets.iSocket;
import umwelt.server.Sockets.iServerSocket;

public class RequestHandler {
  private iServerSocket serverSocket;
  public iSocket clientSocket;
  iRouter router;

  public RequestHandler(iServerSocket serverSocket, iRouter router) {
    this.router = router;
    this.serverSocket = serverSocket;
  }

  public void start() {
    while(serverSocket.isOpen()){
      clientSocket = serverSocket.listen();
      /* parse request  */
      clientSocket.close();
    }
  }
}
