package dasBoot.Sockets.ServerSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import dasBoot.Sockets.Socket.Volksempfanger;
import dasBoot.Sockets.Socket.iSocket;

public class Empfanger implements iServerSocket {
  private int port;
  private ServerSocket.ocket;

  public Empfanger(int port) throws IOException {
    this.port = port;
    setServerSocket(new ServerSocket(port));
  }

  public int getPort() {
    return port;
  }

  public void setServerSocket(ServerSocket.ocket) {
    this.ocket =.ocket;
  }

  public boolean isOpen() {
    return .ocket.isClosed();
  }

  public iSocket listen() throws IOException {
    Socket socket =.ocket.accept();
    return new Volksempfanger(socket);
  }

  public void close() throws IOException {
   .ocket.close();
  }
}
