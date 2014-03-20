package umwelt.mocks.Sockets.Client;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import umwelt.server.Communication.Requests.UmweltRequest;
import umwelt.server.Communication.Responses.iResponse;
import umwelt.server.Sockets.Client.iSocket;

public class _UmweltSocket implements iSocket {
  public boolean socketClosed = false;
  public boolean requestMade = false;
  public boolean responseSent = false;

  public _UmweltSocket() {  }

  public UmweltRequest request() throws IOException {
    requestMade = true;
    String data = "GET / HTTP/1.1\r\n" +
                  "Test: Header\r\n" +
                  "Content-Length: 9\r\n\r\ndata=test";
    return new UmweltRequest(new ByteArrayInputStream(data.getBytes()));
  }

  public void close() { socketClosed = true; }
  public void respondWith(iResponse _) { responseSent = true; }
}
