package umwelt.mocks.Controllers;

import java.util.Hashtable;

import umwelt.server.Controllers.iController;
import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.iResponse;
import umwelt.mocks.Communication.Responses._UmweltResponse;

public class _Controller implements iController {
  private Hashtable<String, iResponse> routes;
  public String type;

  public _Controller(String type) {
    this.type = type;
    routes = new Hashtable<String, iResponse>();
  }

  public iResponse handle(iRequest request) {
    return new _UmweltResponse();
  }

  public Hashtable<String, iResponse> getRoutes(){
    return routes;
  }

  public void stubRoute(String route, iResponse response){
    routes.put(route, response);
  }
}
