package umwelt.mocks.Sockets.ServerSocket;

import umwelt.mocks.Sockets.Socket._Volksempfanger;
import umwelt.server.Sockets.ServerSocket.iServerSocket;
import umwelt.server.Sockets.Socket.iSocket;

public class _Empfanger implements iServerSocket {
  private boolean listen = false;
  public boolean open;
  iSocket listener;
  private int port;

  public _Empfanger(int port) {
    open = true;
    listener = new _Volksempfanger();
    this.port = port;
  }

  public void mockOpen() {
    open = true;
  }

  public void stubListener(iSocket listener) {
    this.listener = listener;
  }

  public iSocket listen() {
    listen = true;
    open = false;
    return listener;
  }

  public boolean isOpen() { return open; }
  public boolean listening() { return listen; }
  public int getPort() { return port; }
}
