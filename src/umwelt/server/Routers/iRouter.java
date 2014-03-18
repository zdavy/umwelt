package umwelt.server.Routers;

import umwelt.server.Communication.*;

public interface iRouter {
  public iResponse route(iRequest request);
  public void addRoute(String method, String uri, iResponse response);
}
