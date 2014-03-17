package umwelt.mocks.Communication;

import umwelt.server.Communication.iRequest;

public class _PostRequest implements iRequest {
  public String method() {
    return "post";
  }

  public String uri() {
    return "/test";
  }

}
