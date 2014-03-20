package umwelt.mocks.Communication.Requests;

import umwelt.server.Communication.Requests.iRequest;

public class _UmweltRequest implements iRequest {
  public boolean proccessed = false;
  public _UmweltRequest() {
  }

  public String method() {
    return "get";
  }

  public String uri() {
    proccessed = true;
    return "/test";
  }
}
