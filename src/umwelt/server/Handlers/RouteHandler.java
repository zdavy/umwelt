package umwelt.server.Handlers;

import umwelt.server.Communication.iRequest;
import umwelt.server.Communication.UmweltResponse;
import umwelt.server.Routers.iRouter;

public class RouteHandler {
  private iRouter router;

  public RouteHandler(iRouter router) {
    setRouter(router);
  }

  public UmweltResponse delegate(iRequest request) {
    return router.route(request);
  }

  public void setRouter(iRouter router) {
    this.router = router;
  }
}
