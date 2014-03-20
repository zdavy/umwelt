/* src.umwelt.test.Controllers.ControllerTest  */
package umwelt.server.Controllers;

import java.util.Hashtable;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.iResponse;

public class AbstractController implements iController {
  Hashtable<String, Hashtable<String, iResponse>> routes;
  Hashtable<String, iResponse> responder;

  public AbstractController(Hashtable<String, Hashtable<String, iResponse>> routes) {
    this.routes = routes;
  }

  public AbstractController() {
    routes = new Hashtable<String, Hashtable<String, iResponse>>();
  }

  public iResponse handle(iRequest request) {
    String method = request.method();
    String uri = request.uri();
    return routes.get(method).get(uri);
  }

  public boolean valid(iRequest request) {
    String method = request.method();
    String uri = request.uri();
    return routes.containsKey(method) && routes.get(method).containsKey(uri);
  }

  public void addRoute(String method, String route, iResponse response) {
    if(routes.containsKey(method)){
      routes.get(method).put(route, response);
    } else {
      responder = new Hashtable<String, iResponse>();
      responder.put(route, response);
      routes.put(method, responder);
    }
  }
}
