package dasBoot.server.Controllers;

import dasBoot.server.Requests.iRequest;
import dasBoot.server.Responses.iResponse;

public interface iController {
  public boolean valid(iRequest request);
  public iResponse handle(iRequest request) throws Exception;
}
