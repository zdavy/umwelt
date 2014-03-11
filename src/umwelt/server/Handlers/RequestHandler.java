package umwelt.server.Handlers;

import umwelt.server.Sockets.iServerSocket;

public class RequestHandler {
  private iServerSocket serverSocket;

  public RequestHandler(iServerSocket serverSocket) {
    this.serverSocket = serverSocket;
  }

  public void start() {
    serverSocket.listen();
  }
}
