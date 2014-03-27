package dasBoot.Controllers;

import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;

public interface iController {
  public boolean valid(iRequest request);
  public iResponse handle(iRequest request) throws Exception;
}
