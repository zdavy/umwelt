package umwelt.mocks.Requests;

import dasBoot.Requests.iRequest;

public class _UmweltRequest implements iRequest {
  public String version = "version";
  public String method = "test";
  public String uri = "/test";
  public int length = 1;

  public boolean proccessed = false;
  public _UmweltRequest() {
  }

  public void stubURI(String uri) {
    this.uri = uri;
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

  public int contentLength() {
    return length;
  }

  public String header(String noop) {
    return noop;
  }

  public String body(String noop) {
    return noop;
  }

  public String version() {
    return version;
  }
}
