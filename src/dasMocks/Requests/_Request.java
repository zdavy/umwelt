package dasMocks.Requests;

import dasBoot.Requests.iRequest;

public class _Request implements iRequest {
  public boolean proccessed = false;
  public int contentLength;
  public String version;
  public String method;
  public String uri;

  public _Request(String method, String uri) {
    this.method = method;
    this.uri = uri;
  }

  public void stubURI(String uri) { this.uri = uri; }
  public void stubMethod(String method) { this.method = method; }
  public void stubVersion(String version) { this.version = version; }
  public String method() { return method; }
  public String uri() { return uri; }
  public String version() { return version; }
  public int contentLength() { return contentLength; }
  public String header(String value) { return "header"; }
  public String body(String value) { return "body"; }
}
