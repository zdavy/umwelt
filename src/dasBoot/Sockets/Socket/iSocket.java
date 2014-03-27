package dasBoot.Sockets.Socket;

import java.io.IOException;

import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;
import dasBoot.Utils.iParser;

public interface iSocket {
  public void close() throws IOException ;
  public iRequest request(iParser parser) throws IOException;
  public void respondWith(iResponse response) throws Exception;
}
