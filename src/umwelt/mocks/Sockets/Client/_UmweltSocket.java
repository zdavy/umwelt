package umwelt.mocks.Sockets.Client;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import umwelt.server.Requests.UmweltRequest;
import umwelt.server.Responses.iResponse;
import umwelt.server.Sockets.Client.iSocket;

public class _UmweltSocket implements iSocket {
  public boolean socketClosed = false;
  public boolean requestMade = false;
  public boolean responseSent = false;
  public iResponse response;
  public String requestData;

  public _UmweltSocket() {
    requestData = "GET / HTTP/1.1\r\n" +
                  "Test: Header\r\n" +
                  "Content-Length: 9\r\n\r\ndata=test";
  }

  public UmweltRequest request() throws IOException {
    requestMade = true;
    return new UmweltRequest(new ByteArrayInputStream(requestData.getBytes()));
  }

  public void stubRequest(String data) {
    requestData = data;
  }

  public void close() { socketClosed = true; }
  public void respondWith(iResponse response) {
    this.response = response;
    responseSent = true;
  }
}
