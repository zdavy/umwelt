package umwelt.mocks.Handlers;

import umwelt.mocks.Communication._UmweltResponse;
import umwelt.server.Communication.iRequest;
import umwelt.server.Communication.iResponse;
import umwelt.server.Handlers.iResponseHandler;

public class _PostHandler implements iResponseHandler {
  private boolean valid = false;
  public _PostHandler() {  }

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
