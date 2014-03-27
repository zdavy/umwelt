package mocks.Sockets.Client;

import java.io.IOException;

import umwelt.Requests.UmweltRequest;

import dasBoot.Responses.iResponse;
import dasBoot.Sockets.Socket.iSocket;
import dasBoot.Utils.iParser;

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

  public UmweltRequest request(iParser parser) throws IOException {
    requestMade = true;
    return new UmweltRequest();
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
