package dasBoot.mocks.Sockets.ServerSocket;

import dasBoot.mocks.Sockets.Socket._Volksempfanger;
import dasBoot.server.Sockets.ServerSocket.iServerSocket;
import dasBoot.server.Sockets.Socket.iSocket;

public class _Empfanger implements iServerSocket {
  private boolean listen = false;
  public boolean open = true;
  iSocket listener;

  public _Empfanger(int port) {
    listener = new _Volksempfanger();
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
}
