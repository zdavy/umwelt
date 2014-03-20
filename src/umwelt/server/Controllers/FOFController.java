package umwelt.server.Controllers;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.UmweltResponse;
import umwelt.server.Communication.Responses.iResponse;

public class FOFController implements iController {
  public FOFController() {
  }

  public String type() {
    return "404";
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
