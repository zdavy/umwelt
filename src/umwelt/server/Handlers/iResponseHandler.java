package umwelt.server.Handlers;

import umwelt.server.Communication.iRequest;
import umwelt.server.Communication.iResponse;

public interface iResponseHandler {
  public String type();
  public iResponse handle(iRequest request);
  public boolean valid(iRequest request);
  public void addRoute(String uri, iResponse response);
}
