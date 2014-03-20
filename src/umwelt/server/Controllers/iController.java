package umwelt.server.Controllers;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.iResponse;

public interface iController {
  public String type();
  public iResponse handle(iRequest request);
  public boolean valid(iRequest request);
  public void addRoute(String uri, iResponse response);
}
