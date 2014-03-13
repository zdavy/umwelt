package umwelt.server.Handlers;

import umwelt.server.Communication.UmweltRequest;
import umwelt.server.Communication.UmweltResponse;

public class Handler {
  public static UmweltResponse delegate(UmweltRequest request) {
    return new UmweltResponse();
  }
}
