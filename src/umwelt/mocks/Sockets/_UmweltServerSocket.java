package umwelt.mocks.Sockets;

import umwelt.server.Sockets.iServerSocket;
import umwelt.server.Sockets.iSocket;

public class _UmweltServerSocket implements iServerSocket {
  private boolean listen = false;
  private boolean open = true;
  private int port;

  public _UmweltServerSocket(int port) { this.port = port; }

  public iSocket listen() {
    listen = true;
    open = false;
    return new _UmweltSocket();
  }

  public boolean isOpen() { return open; }
  public boolean listening() { return listen; }
  public int getPort() { return port; }
}
