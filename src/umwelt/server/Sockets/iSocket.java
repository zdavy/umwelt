package umwelt.server.Sockets;

import java.io.IOException;

import umwelt.server.Communication.UmweltRequest;
import umwelt.server.Communication.iResponse;

public interface iSocket {
  public void close();
  public UmweltRequest request() throws IOException;
  public void respondWith(iResponse response);
}
