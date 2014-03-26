package umwelt.server.Sockets.Socket;

import java.io.IOException;

import umwelt.server.Requests.iRequest;
import umwelt.server.Responses.iResponse;
import umwelt.server.Utils.iParser;

public interface iSocket {
  public void close() throws IOException ;
  public iRequest request(iParser parser) throws IOException;
  public void respondWith(iResponse response) throws Exception;
}
