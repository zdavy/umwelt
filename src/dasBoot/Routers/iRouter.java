package dasBoot.Routers;

import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;

public interface iRouter {
  public iResponse route(iRequest request) throws Exception;
}
