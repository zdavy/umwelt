package umwelt.server.Routers;

import java.io.IOException;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.iResponse;

public interface iRouter {
  public iResponse route(iRequest request) throws IOException ;
}
