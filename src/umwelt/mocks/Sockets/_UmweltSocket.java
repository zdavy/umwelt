package umwelt.mocks.Sockets;

import umwelt.server.Communication.UmweltRequest;
import umwelt.server.Communication.UmweltResponse;
import umwelt.server.Sockets.iSocket;

public class _UmweltSocket implements iSocket {
  private boolean open = true;
  public _UmweltSocket() {
  }
  public void close() {
    open = false;
  }

  public UmweltRequest request() {
    return new UmweltRequest();
  }

  public void respondWith(UmweltResponse response) {
  }

  public boolean isOpen() {
    return open;
  }
}
