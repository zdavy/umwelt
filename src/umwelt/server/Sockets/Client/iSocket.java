package umwelt.server.Sockets.Client;

import java.io.IOException;

import umwelt.server.Communication.Requests.UmweltRequest;
import umwelt.server.Communication.Responses.iResponse;


public interface iSocket {
  public void close();
  public UmweltRequest request() throws IOException;
  public void respondWith(iResponse response);
}
