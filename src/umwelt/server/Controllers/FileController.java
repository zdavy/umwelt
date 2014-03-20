package umwelt.server.Controllers;

import umwelt.mocks.Communication.Responses._UmweltResponse;
import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.iResponse;

public class FileController implements iController {

  public boolean valid(iRequest request) {
    return false;
  }

  public iResponse handle(iRequest request) {
    return new _UmweltResponse();
  }
}
