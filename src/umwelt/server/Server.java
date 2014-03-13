package umwelt.server;
/* Server  */
import umwelt.server.Handlers.RequestHandler;
import umwelt.server.Routers.iRouter;
import umwelt.server.Sockets.iServerSocket;

public class Server {
  private int port;
  private iServerSocket serverSocket;
  private iRouter router;

  public Server(iServerSocket serverSocket, iRouter router) {
    this.router = router;
    this.serverSocket = serverSocket;
    setPort();
  }

  public int getPort() {
    return port;
  }

  public void start() {
    RequestHandler handler = new RequestHandler(serverSocket, router);
    handler.start();
  }

  private void setPort() {
    this.port = serverSocket.getPort();
  }
}
