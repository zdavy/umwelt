package umwelt.server.Handlers;

import java.util.Hashtable;

import umwelt.server.Communication.*;

public class PostHandler implements iResponseHandler {
  public static Hashtable<String, iResponse> routes;

  public PostHandler() {

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
