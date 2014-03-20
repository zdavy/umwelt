package umwelt.server.Controllers;

import java.util.Hashtable;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.FOFResponse;
import umwelt.server.Communication.Responses.iResponse;

public class FOFController implements iController {
  private Hashtable<String, iResponse> routes;

  public FOFController() {
  }

  public String type() {
    return "404";
  }

  public boolean valid(iRequest request) {
    return false;
  }

  public Hashtable<String, iResponse> getRoutes() {
    return routes;
  }

  public void addRoute(String route, iResponse response) {
  }

  public iResponse handle(iRequest request) {
    return new FOFResponse();
  }
}
