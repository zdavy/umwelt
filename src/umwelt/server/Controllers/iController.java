package umwelt.server.Controllers;

import java.io.IOException;

import umwelt.server.Requests.iRequest;
import umwelt.server.Responses.iResponse;

public interface iController {
  public boolean valid(iRequest request);
  public iResponse handle(iRequest request) throws IOException;
}
