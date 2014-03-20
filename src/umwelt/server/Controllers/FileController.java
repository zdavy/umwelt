/* src.umwelt.test.Controllers.FileHandlerTest  */
package umwelt.server.Controllers;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.UmweltResponse;
import umwelt.server.Communication.Responses.iResponse;

public class FileController implements iController {
  public FileController() {
  }

  public String type() {
    return "file";
  }

  public boolean valid(iRequest request) {
    return false;
  }

  public void addRoute(String route, iResponse response) {
  }

  public iResponse handle(iRequest request) {
    return new UmweltResponse();
  }
}
