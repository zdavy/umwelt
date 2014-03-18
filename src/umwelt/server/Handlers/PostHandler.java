package umwelt.server.Handlers;

import java.util.Hashtable;

import umwelt.server.Communication.*;

public class PostHandler {
  public static Hashtable<String, iResponse> routes;
  static {
    routes = new Hashtable<String, iResponse>();
  }

  public static iResponse handle(iRequest request) {
    return new UmweltResponse();
  }

  public static void addRoute(String uri, iResponse response) {
    routes.put(uri, response);
  }
}
