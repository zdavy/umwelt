package mocks.Responses;

import dasBoot.Requests.iRequest;
import dasBoot.Responses.iFactory;
import dasBoot.Responses.iResponse;

public class _UmweltFactory implements iFactory {
  public iResponse get(iRequest request) throws Exception {
    _UmweltResponse response = new _UmweltResponse();
    response.stubCode("200");
    return response;
  }
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
