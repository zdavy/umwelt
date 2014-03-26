package umwelt.mocks.Controllers;

import java.util.Hashtable;

import umwelt.mocks.Responses._UmweltResponse;
import umwelt.server.Controllers.iController;
import umwelt.server.Requests.iRequest;
import umwelt.server.Responses.iResponse;

public class _Controller implements iController {
  private Hashtable<String, iResponse> routes;
  private iResponse response = new _UmweltResponse();
  private boolean valid = false;
  public String type;

  public _Controller(String type) {
    this.type = type;
    routes = new Hashtable<String, iResponse>();
  }

  public iResponse handle(iRequest request) {
    return response;
  }

  public Hashtable<String, iResponse> getRoutes(){
    return routes;
  }

  public boolean valid(iRequest request) {
    return valid;
  }

  public void stubValid(boolean stub) {
    valid = stub;
  }

  public void stubResponse(iResponse stub) {
    response = stub;
  }

  public void stubRoute(String route, iResponse response){
    routes.put(route, response);
  }
}
