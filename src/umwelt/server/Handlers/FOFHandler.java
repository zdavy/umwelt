package umwelt.server.Handlers;

import umwelt.server.Communication.FOFResponse;
import umwelt.server.Communication.iRequest;
import umwelt.server.Communication.iResponse;

public class FOFHandler implements iResponseHandler {
  public FOFHandler() {
  }

  public String type() {
    return "404";
  }

  public boolean valid(iRequest request) {
    return false;
  }

  public void addRoute(String route, iResponse response) {
  }

  public FOFResponse handle(iRequest request) {
    return new FOFResponse();
  }
}
