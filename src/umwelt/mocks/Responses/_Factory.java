package umwelt.mocks.Responses;

import umwelt.server.Responses.iFactory;

public class _Factory implements iFactory {
  public _Response FileNotFound() throws Exception {
    _Response response = new _Response();
    response.stubCode("404");
    return response;
  }

  public _Response MethodNotAllowed() throws Exception {
    _Response response = new _Response();
    response.stubCode("405");
    return response;
  }

  public _Response get() throws Exception {
    _Response response = new _Response();
    response.stubCode("200");
    return response;
  }
}
