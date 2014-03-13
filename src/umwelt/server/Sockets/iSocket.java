package umwelt.server.Sockets;

import umwelt.server.Communication.UmweltRequest;
import umwelt.server.Communication.UmweltResponse;

public interface iSocket {
  public void close();
  public boolean isOpen();
  public UmweltRequest request();
  public void respondWith(UmweltResponse response);
}
