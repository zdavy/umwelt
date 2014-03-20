package umwelt.mocks.Controllers;

import java.util.Hashtable;

import umwelt.mocks.Communication.Responses._UmweltResponse;
import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.iResponse;
import umwelt.server.Controllers.iController;

public class _Controller implements iController {
  public Hashtable<String, iResponse> routes = new Hashtable<String, iResponse>();
  public String name;
  private boolean valid = false;

  public _Controller(String name) {
    this.name = name;
  }

  public String type() {
    return "MockPost";
  }

  public Hashtable<String, iResponse> getRoutes(){
    return routes;
  }

  public void stubRoute(String uri, iResponse response){
    routes.put(uri, response);
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
