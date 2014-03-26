package umwelt.server.Controllers;

import java.io.IOException;
import java.util.Hashtable;

import umwelt.server.Requests.iRequest;
import umwelt.server.Responses.UmweltFactory;
import umwelt.server.Responses.iResponse;

public class UmweltController implements iController {
  Hashtable<String, Hashtable<String, iResponse>> routes;
  Hashtable<String, iResponse> responder;

  public UmweltController() {
    routes = new Hashtable<String, Hashtable<String, iResponse>>();
  }

  public iResponse handle(iRequest request) throws IOException {
    String route = request.uri();
    String method = request.method();
    UmweltFactory factory = new UmweltFactory("DIR");
      iResponse response = routes.get(route).get(method);
      return (response == null) ? factory.MethodNotAllowed() : response;
  }

  public boolean valid(iRequest request) {
    String route = request.uri();
    return routes.containsKey(route);
  }

  public void get(String route, iResponse response) {
    addRoute("get", route, response);
  }

  public void post(String route, iResponse response) {
    addRoute("post", route, response);
  }

  public void put(String route, iResponse response) {
    addRoute("put", route, response);
  }

  public void patch(String route, iResponse response) {
    addRoute("patch", route, response);
  }

  public void delete(String route, iResponse response) {
    addRoute("delete", route, response);
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
