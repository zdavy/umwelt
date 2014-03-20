/* src.umwelt.test.Controllers.GetHandlerTest */
package umwelt.server.Controllers;

import java.util.Hashtable;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.iResponse;

public class GetController implements iController {
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
