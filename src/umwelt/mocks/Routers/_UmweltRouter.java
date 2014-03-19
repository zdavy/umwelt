package umwelt.mocks.Routers;

import umwelt.server.Communication.UmweltResponse;
import umwelt.server.Communication.iRequest;
import umwelt.server.Communication.iResponse;
import umwelt.server.Routers.iRouter;

public class _UmweltRouter implements iRouter {
  iRequest routed;

  public _UmweltRouter() {
  }

  public void addRoute(String method, String uri, iResponse response){

  }

  public UmweltResponse route(iRequest request) {
    routed = request;
    return new UmweltResponse();
  }

  public boolean routed_with(iRequest request) {
    return routed.equals(request);
  }
}
