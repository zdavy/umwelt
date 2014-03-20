/* src.umwelt.test.Routers.UmweltRouterTest */
package umwelt.server.Routers;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.UmweltResponse;
import umwelt.server.Communication.Responses.iResponse;
import umwelt.server.Controllers.iController;

public class UmweltRouter implements iRouter {
  iController[] controllers;

  public UmweltRouter(iController... controllers) {
    this.controllers = controllers;
  }

  public iResponse route(iRequest request){
    return handle(request);
  };

  public void addRoute(String method, String uri, iResponse response) {
      iController controller = determineController(method);
      if(controller == null) {
        System.out.println("That Controller Doesn't Exist Yet :-)");
      } else {
      controller.addRoute(uri, response);
    }
  }

  private iController determineController(String method) {
    for(iController controller : controllers) {
      if(controller.type().equals(method)) {
        return controller;
      }
    }
    return null;
  }

  private iController determineController(iRequest request) {
    for(iController controller : controllers) {
      if(controller.valid(request)) {
        return controller;
      }
    }
    return null;
  }

  private iResponse handle(iRequest request){
    iController controller = determineController(request);
    if(controller == null) {
      return new UmweltResponse();
    }
    return controller.handle(request);
  }
}
