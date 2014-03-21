package umwelt.server.Controllers;

import java.io.File;
import java.io.IOException;

import umwelt.server.Communication.Requests.iRequest;
import umwelt.server.Communication.Responses.ResponseFactory;
import umwelt.server.Communication.Responses.iResponse;

public class FileController implements iController {
  private String DIR = System.getProperty("user.dir");

  public FileController() {
    this.DIR = DIR + "/public";
  }

  public FileController(String dir) {
    this.DIR = DIR + dir;
  }

  public FileController(boolean root, String dir) {
    if(root == false) {
      this.DIR = dir;
    }
  }

  public boolean valid(iRequest request) {
    File file = new File(DIR + request.uri());
    return file.isFile() && file.canRead();
  }

  public iResponse handle(iRequest request) throws IOException {
    return new ResponseFactory().file(DIR, request);
  }
}
