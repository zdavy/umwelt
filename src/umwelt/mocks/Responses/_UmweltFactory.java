package umwelt.mocks.Responses;

import umwelt.server.Responses.iFactory;
import umwelt.server.Responses.iResponse;

public class _UmweltFactory implements iFactory {
  public iResponse FileNotFound() throws Exception {
    _UmweltResponse response = new _UmweltResponse();
    response.stubCode("404");
    return response;
  }

  public iResponse MethodNotAllowed() throws Exception {
    _UmweltResponse response = new _UmweltResponse();
    response.stubCode("405");
    return response;
  }
}
