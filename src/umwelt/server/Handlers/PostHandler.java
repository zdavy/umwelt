package umwelt.server.Handlers;

import umwelt.server.Communication.PostResponse;
import umwelt.server.Communication.iRequest;
import umwelt.server.Communication.iResponse;

public class PostHandler {
  public static iResponse handle(iRequest request) {
    return new PostResponse();
  }
}
