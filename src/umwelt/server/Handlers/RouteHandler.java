package umwelt.server.Handlers;

import umwelt.server.Communication.UmweltRequest;
import umwelt.server.Communication.UmweltResponse;
import umwelt.server.Routers.iRouter;

public class RouteHandler {
  public RouteHandler(iRouter router) {
  }

  public UmweltResponse delegate(UmweltRequest request) {
    return new UmweltResponse();
  }
}
