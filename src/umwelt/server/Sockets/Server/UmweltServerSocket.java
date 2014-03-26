package umwelt.server.Sockets.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import umwelt.server.Sockets.Client.UmweltSocket;
import umwelt.server.Sockets.Client.iSocket;

public class UmweltServerSocket implements iServerSocket {
  private int port;
  private ServerSocket serverSocket;

  public UmweltServerSocket(int port) throws IOException {
    this.port = port;
    setServerSocket(new ServerSocket(port));
  }

  public int getPort() {
    return port;
  }

  public void setServerSocket(ServerSocket serverSocket) {
    this.serverSocket = serverSocket;
  }

  public boolean isOpen() {
    return !serverSocket.isClosed();
  }

  public iSocket listen() throws IOException {
    Socket clientSocket = serverSocket.accept();
    return new UmweltSocket(clientSocket);
  }

  public void close() throws IOException {
    serverSocket.close();
  }
}
