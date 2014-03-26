package umwelt.server.Responses;
import umwelt.server.Requests.iRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class UmweltFactory implements iFactory {
  private iResponse response;
  private String DIR;

  public UmweltFactory() {
    DIR = System.getProperty("user.dir") + "/public/";
  }

/*_________________________________ RESPONSE ________________________________ */

  public iResponse get(String file, iRequest request) throws IOException {
    response = new UmweltResponse();
    set200();
    response.setHeader("Content-Type", "text/plain");
    response.setContent(bytify(file));
    return response;
  }

  private void set200() {
    response.setStatus("200", "OK");
    response.setVersion("HTTP/1.1");
  }

/*____________________________________404____________________________________ */

  public iResponse FileNotFound() throws IOException {
    response = new UmweltResponse();
    set404();
    response.setHeader("Content-Type", "text/html");
    assign404File(DIR + "404.html");
    return response;
  }

  private void set404() {
    response.setStatus("404", "Not Found");
    response.setVersion("HTTP/1.1");
  }

  public void assign404File(String file) {
    try {
      response.setContent(bytify(file)); }
    catch (Exception e) {
      response.setContent("404 File Not Found"); }
  }

/*_____________________________Method Not Allowed____________________________ */

  public iResponse MethodNotAllowed() throws IOException {
    response = new UmweltResponse();
    set405();
    response.setHeader("Content-Type", "text/html");
    assign405File(DIR + "405.html");
    return response;
  }

  private void set405() {
    response.setStatus("405", "Method Not Allowed");
    response.setVersion("HTTP/1.1");
  }

  public void assign405File(String file) {
    try {
      response.setContent(bytify(file)); }
    catch (Exception e) {
      response.setContent("405 Method Not Allowed"); }
  }
/*___________________________________________________________________________ */

  private byte[] bytify(String path) throws IOException {
    Path file = Paths.get(path);
    return Files.readAllBytes(file);
  }
}
