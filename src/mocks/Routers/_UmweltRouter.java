package mocks.Routers;

import dasBoot.Controllers.iController;
import dasBoot.Requests.iRequest;
import dasBoot.Routers.iRouter;

import mocks.Responses._UmweltResponse;

public class _UmweltRouter implements iRouter {
  iRequest routed;

  public _UmweltRouter(iController[] controllers) {
  }

  @Override
  public _UmweltResponse route(iRequest request) {
    routed = request;
    return new _UmweltResponse();
  }

  public boolean routed_with(iRequest request) {
    return routed.equals(request);
  }
}
