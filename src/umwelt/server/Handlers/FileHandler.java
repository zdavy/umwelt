/* src.umwelt.test.Handlers.FileHandlerTest  */
package umwelt.server.Handlers;

import umwelt.server.Communication.FileResponse;
import umwelt.server.Communication.iRequest;
import umwelt.server.Communication.iResponse;

public class FileHandler implements iResponseHandler {
  public FileHandler() {
  }

  public String type() {
    return "file";
  }

  public boolean valid(iRequest request) {
    return false;
  }

  public void addRoute(String route, iResponse response) {
  }

  public FileResponse handle(iRequest request) {
    return new FileResponse();
  }
}
