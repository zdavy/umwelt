package dasMocks.Controllers;
import dasBoot.Controllers.iController;

import java.io.File;

import dasMocks.Responses._Factory;
import dasMocks.Responses._Response;
import dasBoot.Requests.iRequest;

public class _Controller implements iController {
  public _Factory factory;
  public boolean method;

  public _Controller(_Factory factory) {
    this.factory = factory;
  }

  public boolean valid(iRequest request) {
    String dir = System.getProperty("user.dir");
    String file = dir + request.uri();
    return new File(file).exists();
  }

  public _Response handle(iRequest request) {
    _Response response = new _Response();
    String code = validMethod() ? "200" : "405";
    response.stubCode(code);
    return response;
  }

  public void stubMethodExists(boolean method) { this.method = true; }
  private boolean validMethod() { return method; }
}
