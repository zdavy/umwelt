package umwelt.mocks.Controllers;
import umwelt.server.Controllers.iController;

import java.io.File;

import umwelt.mocks.Responses._Factory;
import umwelt.mocks.Responses._Response;
import umwelt.server.Requests.iRequest;

public class _Controller implements iController {
  public _Response response = new _Response();
  public _Factory factory;
  public boolean method;

  public _Controller(_Factory factory) {
    this.factory = factory;
  }

  public boolean valid(iRequest request) {
    return new File(System.getProperty("user.dir") + request.uri()).exists();
  }

  public _Response handle(iRequest request) {
    if (validMethod()) {
      response.stubCode("200"); }
    else {
      response.stubCode("405"); }
    return response;
  }

  public void stubMethodExists(boolean method) { this.method = true; }
  public void stubResponse(_Response stub) { response = stub; }
  private boolean validMethod() { return method; }
}
