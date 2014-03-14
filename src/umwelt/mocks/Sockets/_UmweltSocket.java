package umwelt.mocks.Sockets;

import umwelt.server.Communication.UmweltRequest;
import umwelt.server.Communication.UmweltResponse;
import umwelt.server.Sockets.iSocket;

public class _UmweltSocket implements iSocket {
  private boolean open = true;
  public boolean requestMade = false;
  public boolean responseSent = false;
  public _UmweltSocket() {
  }

  public void close() {
    open = false;
  }

  public UmweltRequest request() {
    requestMade = true;
    return new UmweltRequest();
  }

  public void respondWith(UmweltResponse response) {
    responseSent = true;
  }

  public boolean isOpen() {
    return open;
  }
}
