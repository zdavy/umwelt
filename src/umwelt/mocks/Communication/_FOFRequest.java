package umwelt.mocks.Communication;

import umwelt.server.Communication.iRequest;

public class _FOFRequest implements iRequest {
  public String method() {
    return "test";
  }

  public String uri() {
    return "uri";
  }

}
