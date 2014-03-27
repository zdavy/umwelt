package dasBoot.mocks.Routers;

import dasBoot.mocks.Responses._Response;
import dasBoot.server.Controllers.iController;
import dasBoot.server.Requests.iRequest;
import dasBoot.server.Routers.iRouter;

public class _Router implements iRouter {
  public boolean wasRouted = false;
  public iRequest routed;
  public _Router(iController[] controllers) {  }

  @Override
  public _Response route(iRequest request) {
    wasRouted = true;
    routed = request;
    return new _Response();
  }

  public boolean routed_with(iRequest request) {
    return routed.equals(request);
  }
}
