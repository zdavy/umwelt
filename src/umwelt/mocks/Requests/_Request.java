package umwelt.mocks.Requests;

import java.io.InputStream;

import umwelt.server.Requests.iRequest;

public class _Request implements iRequest {
  public String method = "test";
  public String uri = "/test";
  public boolean proccessed = false;

  public _Request(String method, String uri) {
    this.method = method;
    this.uri = uri;
  }

  public void stubURI(String uri) { this.uri = uri; }
  public void stubMethod(String method) { this.method = method; }

  public String method() { return method; }
  public String uri() { return uri; }

  public void read(InputStream _) {  }
}
