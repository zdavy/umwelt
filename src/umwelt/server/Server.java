package umwelt.server;

import umwelt.server.Handlers.RequestHandler;
import umwelt.server.Sockets.iServerSocket;

public class Server {
  private int port;
  iServerSocket serverSocket;

  public Server(iServerSocket serverSocket) {
    this.serverSocket = serverSocket;
    setPort();
  }

  public int getPort() {
    return port;
  }

  public void start() {
    RequestHandler handler = new RequestHandler(serverSocket);
    handler.start();
  }

  private void setPort() {
    this.port = serverSocket.getPort();
  }
}
