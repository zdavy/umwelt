/* src.umwelt.test.Handlers.GetHandlerTest */
package umwelt.server.Handlers;

import java.util.Hashtable;
import umwelt.server.Communication.*;

public class GetHandler implements iResponseHandler {
  private Hashtable<String, iResponse> routes = new Hashtable<String, iResponse>();

  public String type(){
    return "get";
  }

  public boolean valid(iRequest request){
    return false;
  }

  public iResponse handle(iRequest request) {
    return routes.get(request.uri()).proccess(request);
  }

  public void addRoute(String uri, iResponse response) {
    routes.put(uri, response);
  }
}
