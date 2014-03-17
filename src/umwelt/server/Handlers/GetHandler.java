package umwelt.server.Handlers;

import umwelt.server.Communication.GetResponse;
import umwelt.server.Communication.iRequest;
import umwelt.server.Communication.iResponse;

public class GetHandler {
  static String uri;
  public static iResponse handle(iRequest request) {
    uri = request.uri();
    return new GetResponse();
  }
}
