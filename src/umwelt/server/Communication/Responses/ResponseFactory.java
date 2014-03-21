package umwelt.server.Communication.Responses;

import java.nio.file.*;
import java.io.IOException;
import java.util.Hashtable;

import umwelt.server.Communication.Requests.iRequest;

public class ResponseFactory {
  private UmweltResponse response;
  private Hashtable<String, String> MIMETypes;

  public ResponseFactory() {
    response = new UmweltResponse();
    MIMETypes = new Hashtable<String, String>();
    setMIMETypes();
  }

/*_________________________________RESPONSES_________________________________ */
/*______________________________ FILE RESPONSE ______________________________ */
  public iResponse file(String DIR, iRequest request) throws IOException {
    String uri = request.uri();
    String file = DIR + uri;
    set200();
    response.header("Content-Type", determineMIMEType(uri));
    response.setContent(bytify(file));
    return response;
  }
/*____________________________________END____________________________________ */
/*_________________________________RESPONSES_________________________________ */

  private void setMIMETypes() {
    MIMETypes.put(  ".js", "text/javascript");
    MIMETypes.put(".html", "text/html");
    MIMETypes.put( ".png", "image/png");
    MIMETypes.put( ".jpg", "image/jpg");
    MIMETypes.put( ".css", "text/css");
  }

  private byte[] bytify(String path) throws IOException {
    Path file = Paths.get(path);
    return Files.readAllBytes(file);
  }

  private void set200() {
    response.status("200", "OK");
    response.version("HTTP/1.1");
  }

  private String determineMIMEType(String filename) {
    String type = getExtensions(filename);
    if(MIMETypes.containsKey(type)) {
      return MIMETypes.get(type);
    } else {
      return "text/plain";
    }
  }

  private String getExtensions(String filename) {
    try
      { return filename.substring(filename.lastIndexOf(".")); }
    catch (StringIndexOutOfBoundsException e) 
      {  return "ERROR"; }
  }
}
