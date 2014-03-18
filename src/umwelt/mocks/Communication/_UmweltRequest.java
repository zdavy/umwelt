package umwelt.mocks.Communication;

import umwelt.server.Communication.iRequest;

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
