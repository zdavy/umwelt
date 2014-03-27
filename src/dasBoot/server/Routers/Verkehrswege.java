package dasBoot.server.Routers;

import dasBoot.server.Controllers.iController;
import dasBoot.server.Requests.iRequest;
import dasBoot.server.Responses.iFactory;
import dasBoot.server.Responses.iResponse;

public class Verkehrswege implements iRouter {
  iFactory factory;
  private iController[] controllers;

  public Verkehrswege(iController[] controllers, iFactory factory) {
    this.factory = factory;
    this.controllers = controllers;
  }

  public iResponse route(iRequest request) throws Exception {
    iController controller = determineController(request);
    try {
      return controller.handle(request);}
    catch (Exception e) {
      return factory.FileNotFound(); }
  }

  private iController determineController(iRequest request) {
    iController validController = null;
    for(iController controller : controllers) {
      if(controller.valid(request)) {
        validController = controller;
      }
    }
    return validController;
  }
}
