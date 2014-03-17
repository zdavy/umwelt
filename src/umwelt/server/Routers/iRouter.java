package umwelt.server.Routers;

import umwelt.server.Communication.*;

public interface iRouter {
  public UmweltResponse route(iRequest request);
}
