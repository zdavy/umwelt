package umwelt.mocks.Sockets;

import umwelt.server.Communication.UmweltRequest;
import umwelt.server.Communication.UmweltResponse;
import umwelt.server.Sockets.iSocket;

public class _UmweltSocket implements iSocket {
  public boolean socketClosed = false;
  public boolean requestMade = false;
  public boolean responseSent = false;

  public _UmweltSocket() {  }

  public UmweltRequest request() {
    requestMade = true;
    return new UmweltRequest();
  }

  public void close() { socketClosed = true; }
  public void respondWith(UmweltResponse _) { responseSent = true; }
}
