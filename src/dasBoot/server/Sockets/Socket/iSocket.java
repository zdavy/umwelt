package dasBoot.server.Sockets.Socket;

import java.io.IOException;

import dasBoot.server.Requests.iRequest;
import dasBoot.server.Responses.iResponse;
import dasBoot.server.Utils.iParser;

public interface iSocket {
  public void close() throws IOException ;
  public iRequest request(iParser parser) throws IOException;
  public void respondWith(iResponse response) throws Exception;
}
