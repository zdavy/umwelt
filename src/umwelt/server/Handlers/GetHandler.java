package umwelt.server.Handlers;

import umwelt.server.Communication.*;

public class GetHandler {
  static String uri;
  public static iResponse handle(iRequest request) {
    uri = request.uri();
    return new UmweltResponse();
  }
}
