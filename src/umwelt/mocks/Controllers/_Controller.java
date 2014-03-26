package umwelt.mocks.Controllers;
import umwelt.server.Controllers.iController;

import java.util.Hashtable;

import umwelt.mocks.Responses._Response;
import umwelt.server.Requests.iRequest;

public class _Controller implements iController {
  private Hashtable<String, _Response> routes;
  private _Response response = new _Response();
  private boolean valid = false;
  public String type;

  public _Controller(String type) {
    this.type = type;
    routes = new Hashtable<String, _Response>();
  }

  public _Response handle(iRequest request) {
    return response;
  }

  public Hashtable<String, _Response> getRoutes(){
    return routes;
  }

  public boolean valid(iRequest request) {
    return valid;
  }

  public void stubValid(boolean stub) {
    valid = stub;
  }

  public void stubResponse(_Response stub) {
    response = stub;
  }

  public void stubRoute(String route, _Response response){
    routes.put(route, response);
  }
}
