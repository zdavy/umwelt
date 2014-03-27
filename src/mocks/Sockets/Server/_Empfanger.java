package mocks.Sockets.Server;

import mocks.Sockets.Client._Volksempfanger;

import dasBoot.Sockets.ServerSocket.iServerSocket;
import dasBoot.Sockets.Socket.iSocket;

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

  public void close() {

  }

  public boolean isOpen() { return open; }
  public boolean listening() { return listen; }
}
