/* src.umwelt.test.Routers.UmweltRouterTest */
package umwelt.server.Routers;

import java.util.Enumeration;
import java.util.Hashtable;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.iResponse;
import umwelt.server.Controllers.FOFController;
import umwelt.server.Controllers.iController;

public class UmweltRouter implements iRouter {
  Hashtable<String, iController> routeList = new Hashtable<String, iController>();
  iController fofController = new FOFController();
  iController[] controllers;

  public UmweltRouter(iController... controllers) {
    this.controllers = controllers;
    setRoutes();
  }

  private void setRoutes() {
    for(iController controller : controllers) {
      Enumeration<String> routes = controller.getRoutes().keys();
      while(routes.hasMoreElements()) {
        routeList.put(routes.nextElement(), controller);
      }
    }
  }

  public iResponse route(iRequest request){
    return determineController(request).handle(request);
  }

  private iController determineController(iRequest request) {
    String key = request.method() + request.uri();
    if(routeList.containsKey(key)){
      return routeList.get(key);
    }
    return fofController;
  }
}
