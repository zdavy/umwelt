package umwelt.server.Routers;

import umwelt.server.Requests.iRequest;
import umwelt.server.Responses.iResponse;

public interface iRouter {
  public iResponse route(iRequest request) throws Exception;
}
