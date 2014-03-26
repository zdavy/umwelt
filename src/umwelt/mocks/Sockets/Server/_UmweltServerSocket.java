package umwelt.mocks.Sockets.Server;

import umwelt.mocks.Sockets.Client._UmweltSocket;
import umwelt.server.Sockets.Client.iSocket;
import umwelt.server.Sockets.Server.iServerSocket;

public class _UmweltServerSocket implements iServerSocket {
  private boolean listen = false;
  public boolean open;
  iSocket listener;
  private int port;

  public _UmweltServerSocket(int port) {
    open = true;
    listener = new _UmweltSocket();
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
