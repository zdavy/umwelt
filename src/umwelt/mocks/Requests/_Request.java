package umwelt.mocks.Requests;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import umwelt.server.Requests.iRequest;

public class _Request implements iRequest {
  public _Request(ByteArrayInputStream _) {  }

  public String method = "test";
  public String uri = "/test";
  public boolean proccessed = false;

  public void stubURI(String uri) {
    this.uri = uri;
  }

  public void read(InputStream input) {

  }

  public void stubMethod(String method) {
    this.method = method;
  }

  public String method() {
    return method;
  }

  public String uri() {
    return uri;
  }
}
