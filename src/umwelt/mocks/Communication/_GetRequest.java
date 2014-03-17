package umwelt.mocks.Communication;

import umwelt.server.Communication.iRequest;

public class _GetRequest implements iRequest {
  public boolean uri_requested = false;
  public String method() {
    return "get";
  }

  public String uri() {
    uri_requested = true;
    return "/test";
  }

}
