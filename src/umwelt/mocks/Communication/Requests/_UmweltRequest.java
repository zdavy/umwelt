package umwelt.mocks.Communication.Requests;

import umwelt.server.Communication.Requests.iRequest;

public class _UmweltRequest implements iRequest {
  public String method = "";
  public String uri = "/";

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
    proccessed = true;
    return uri;
  }
}
