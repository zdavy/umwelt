package umwelt.server.Sockets.Client;

import java.io.IOException;

import umwelt.server.Requests.UmweltRequest;
import umwelt.server.Responses.iResponse;

public interface iSocket {
  public void close() throws IOException ;
  public UmweltRequest request() throws IOException;
  public void respondWith(iResponse response) throws Exception;
}
