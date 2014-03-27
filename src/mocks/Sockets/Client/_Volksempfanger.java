package mocks.Sockets.Client;
import dasBoot.Sockets.Socket.iSocket;
import dasBoot.Utils.iParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import mocks.Requests._UmweltRequest;

import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;

public class _Volksempfanger implements iSocket {
  public InputStream input;
  public boolean wasRequested = false;
  public boolean wasResponded = false;
  public boolean wasClosed = false;
  public iResponse response;
  public String requestData;
  public _UmweltRequest request;

  public _Volksempfanger() {
    request = new _UmweltRequest();
  }

  public void stubInputStream(String input) {
    this.input = new ByteArrayInputStream(input.getBytes(Charset.forName("utf-8")));
  };

  public iRequest request(iParser parser) throws IOException {
    wasRequested = true;
    return parser.request(input);
  }

  public void stubRequest(String method, String uri) {
    request = new _UmweltRequest();
    request.stubMethod(method);
    request.stubURI(uri);
  }

  public void respondWith(iResponse response) throws Exception {
    wasResponded = true;
    this.response = response;
  }

  public void close() {
    wasClosed = true;
  }
}
