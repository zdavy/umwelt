package dasBoot.Sockets.ServerSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import dasBoot.Sockets.Socket.Volksempfanger;
import dasBoot.Sockets.Socket.iSocket;

public class Empfanger implements iServerSocket {
  private int port;
  private ServerSocket serverSocket;

  public Empfanger(int port) throws IOException {
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
    Socket socket = serverSocket.accept();
    return new Volksempfanger(socket);
  }

  public void close() throws IOException {
    serverSocket.close();
  }
}
