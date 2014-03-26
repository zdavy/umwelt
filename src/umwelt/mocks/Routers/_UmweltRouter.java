package umwelt.mocks.Routers;

import umwelt.mocks.Responses._UmweltResponse;
import umwelt.server.Controllers.iController;
import umwelt.server.Requests.iRequest;
import umwelt.server.Routers.iRouter;

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
