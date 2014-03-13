package umwelt.mocks.Sockets;

import umwelt.server.Sockets.iSocket;

public class _UmweltSocket implements iSocket {
  private boolean open = true;
  public _UmweltSocket() {
  }
  public void close() {
    open = false;
  }

  public boolean isOpen() {
    return open;
  }
}
