package umwelt.server.Routers;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.iResponse;

public interface iRouter {
  public iResponse route(iRequest request);
}
