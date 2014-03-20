package umwelt.mocks.Controllers;

import umwelt.mocks.Communication.Responses._UmweltResponse;
import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.iResponse;
import umwelt.server.Controllers.Controller;

public class _PostController implements Controller {
  private boolean valid = false;
  public _PostController() {  }

  public String type() {
    return "MockPost";
  }

  public void stubValid(boolean response) {
    this.valid = response;
  }

  public boolean valid(iRequest request) {
    return this.valid;
  }

  public iResponse handle(iRequest request) {
    return new _UmweltResponse();
  }

  public void addRoute(String route, iResponse response) {

  }

}
