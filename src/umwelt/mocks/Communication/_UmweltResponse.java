package umwelt.mocks.Communication;

import umwelt.server.Communication.iRequest;
import umwelt.server.Communication.iResponse;

public class _UmweltResponse implements iResponse {
  public _UmweltResponse() {
  }
  public _UmweltResponse process(iRequest request) {
    return this;
  }
}
