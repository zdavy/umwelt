/* src.umwelt.test.Handlers.GetHandlerTest */
package umwelt.server.Handlers;

import java.util.Hashtable;

import umwelt.server.Communication.*;

public class GetHandler {
  public static Hashtable<String, iResponse> routes;
  static String uri;
  static {
    routes = new Hashtable<String, iResponse>();
  }

  public static iResponse handle(iRequest request) {
    uri = request.uri();
    return routes.get(uri).process(request);
  }

  public static void addRoute(String uri, iResponse response) {
    routes.put(uri, response);
  }
}
