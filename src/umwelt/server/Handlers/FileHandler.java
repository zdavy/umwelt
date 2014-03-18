package umwelt.server.Handlers;

import umwelt.server.Communication.FileResponse;
import umwelt.server.Communication.iRequest;

public class FileHandler {
  public static FileResponse handle(iRequest request) {
    return new FileResponse();
  }

  public static boolean exists(String file) {
    return false;
  }
}
