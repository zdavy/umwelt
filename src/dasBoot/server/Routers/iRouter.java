package dasBoot.server.Routers;

import dasBoot.server.Requests.iRequest;
import dasBoot.server.Responses.iResponse;

public interface iRouter {
  public iResponse route(iRequest request) throws Exception;
}
