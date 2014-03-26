package umwelt.mocks.Sockets.Socket;
import umwelt.server.Sockets.Socket.iSocket;
import umwelt.server.Utils.iParser;

import java.io.IOException;

import umwelt.mocks.Requests._Request;
import umwelt.server.Responses.iResponse;

public class _Volksempfanger implements iSocket {
  public iResponse response;
  public String requestData;
  public _Request request;

  public _Volksempfanger() {
    request = new _Request("test", "/test");
  }

  public _Request request(iParser parser) throws IOException {
    return request;
  }

  public void stubRequest(String method, String uri) {
    request = new _Request(method, uri);
  }

  public void respondWith(iResponse response) throws Exception {
    this.response = response;
  }

  public void close() { }
}
