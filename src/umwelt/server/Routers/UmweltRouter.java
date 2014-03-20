/* src.umwelt.test.Routers.UmweltRouterTest */
package umwelt.server.Routers;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.iResponse;
import umwelt.server.Controllers.FOFController;
import umwelt.server.Controllers.iController;

public class UmweltRouter implements iRouter {
  private iController _404_ = new FOFController();
  private iController[] controllers;

  public UmweltRouter(iController... controllers) {
    this.controllers = controllers;
  }

  public iResponse route(iRequest request){
    return determineController(request).handle(request);
  }

  private iController determineController(iRequest request) {
    for(iController controller : controllers) {
      if(controller.valid(request)) {
        return controller;
      }
    }
    return _404_;
  }
}
