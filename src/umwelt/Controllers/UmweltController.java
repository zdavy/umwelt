package umwelt.Controllers;

import java.util.Hashtable;

import umwelt.Responses.UmweltFactory;

import dasBoot.Controllers.iController;
import dasBoot.Requests.iRequest;
import dasBoot.Responses.iFactory;
import dasBoot.Responses.iResponse;

public class UmweltController implements iController {
  protected Hashtable<String, Hashtable<String, iResponse>> routes;
  protected Hashtable<String, iResponse> responder;
  protected String DIR;
  protected iFactory factory;

  public UmweltController() {
    DIR = System.getProperty("user.dir");
    routes = new Hashtable<String, Hashtable<String, iResponse>>();
  }

  public iResponse handle(iRequest request) throws Exception {
    newFactory();
    String route = request.uri();
    String method = request.method();
    iResponse response = routes.get(route).get(method);
    return (response == null) ? factory.MethodNotAllowed() : response.proccess(request);
  }

  protected void newFactory() {
    factory = new UmweltFactory(DIR);
  }

  public boolean valid(iRequest request) {
    String route = request.uri();
    return routes.containsKey(route);
  }

  public void get(String route, iResponse response) {
    addRoute("GET", route, response);
  }

  public void post(String route, iResponse response) {
    addRoute("POST", route, response);
  }

  public void put(String route, iResponse response) {
    addRoute("PUT", route, response);
  }

  public void patch(String route, iResponse response) {
    addRoute("PATCH", route, response);
  }

  public void delete(String route, iResponse response) {
    addRoute("DELETE", route, response);
  }

  public void addRoute(String method, String route, iResponse response) {
    if(routes.containsKey(route)){
      routes.get(route).put(method, response);
    } else {
      responder = new Hashtable<String, iResponse>();
      responder.put(method, response);
      routes.put(route, responder);
    }
  }
}
