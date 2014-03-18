package umwelt.server.Handlers;

import umwelt.server.Communication.FOFResponse;
import umwelt.server.Communication.iRequest;
import umwelt.server.Communication.iResponse;

public class FOFHandler {
  public static iResponse handle(iRequest request) {
    return new FOFResponse();
  }
}
