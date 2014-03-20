package umwelt.server.Controllers;

import java.util.Hashtable;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.UmweltResponse;
import umwelt.server.Communication.Responses.iResponse;

public class PostController implements iController {
  public static Hashtable<String, iResponse> routes;

  public PostController() {

  }

  public String type() {
    return "post";
  }

  public boolean valid(iRequest request){
    return false;
  }

  static {
    routes = new Hashtable<String, iResponse>();
  }

  public iResponse handle(iRequest request) {
    return new UmweltResponse();
  }

  public void addRoute(String uri, iResponse response) {
    routes.put(uri, response);
  }
}
