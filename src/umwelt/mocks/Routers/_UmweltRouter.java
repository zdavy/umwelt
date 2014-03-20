package umwelt.mocks.Routers;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.UmweltResponse;
import umwelt.server.Communication.Responses.iResponse;
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
