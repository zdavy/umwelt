package umwelt.mocks.Sockets.Socket;
import umwelt.server.Sockets.Socket.iSocket;
import umwelt.server.Utils.iParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import umwelt.mocks.Requests._Request;
import umwelt.server.Responses.iResponse;

public class _Volksempfanger implements iSocket {
  public boolean socketClosed = false;
  public boolean requestMade = false;
  public boolean responseSent = false;
  public iResponse response;
  public String requestData;

  public _Volksempfanger() {
    requestData = "GET / HTTP/1.1\r\n" +
                  "Test: Header\r\n" +
                  "Content-Length: 9\r\n\r\ndata=test";
  }

  public _Request request(iParser parser) throws IOException {
    requestMade = true;
    return new _Request(new ByteArrayInputStream(requestData.getBytes()));
  }

  public void stubRequest(String data) {
    requestData = data;
  }

  public void close() { socketClosed = true; }
  public void respondWith(iResponse response) throws Exception {
    this.response = response;
    responseSent = true;
  }
}
