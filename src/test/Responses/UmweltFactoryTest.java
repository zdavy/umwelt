package umwelt.test.Responses;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;

import dasBoot.Responses.iResponse;

import umwelt.mocks.Requests._UmweltRequest;
import umwelt.server.Responses.UmweltFactory;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class UmweltFactoryTest {
  String DIR = System.getProperty("user.dir");
  UmweltFactory factory;
  iResponse response;
  _UmweltRequest request;

  @Before public void init() {
    factory = new UmweltFactory(DIR + "/public");
    request = new _UmweltRequest();
  }

/*_______________________________GET  RESPONSE_______________________________ */

  @Test public void GetResponse() throws Exception {
    request.stubURI("/index");
    response = factory.get(request);

    Hashtable<String, String> responseLine = response.getResponseLine();
    assertEquals("200", responseLine.get("code"));
    assertEquals("OK", responseLine.get("reason"));

    Hashtable<String, String> header = response.getHeader();
    assertEquals("0", header.get("Content-Length"));
  }

/*____________________________ 404 HTML RESPONSE ____________________________ */

  @Test public void F0FResponseIf404TML() throws Exception {
    response = factory.FileNotFound();

    Hashtable<String, String> responseLine = response.getResponseLine();
    assertEquals("404", responseLine.get("code"));
    assertEquals("Not Found", responseLine.get("reason"));

    String stringContent = new String(response.getBody().get("content"), "UTF-8");
    assertThat(stringContent, containsString("<HTML>"));
  }

/*___________________________ 404 STOCK RESPONSE ____________________________ */

  @Test public void F0FResponseIfNoHTML() throws Exception {
    response = new UmweltFactory(DIR).FileNotFound();

    Hashtable<String, String> responseLine = response.getResponseLine();
    assertEquals("404", responseLine.get("code"));
    assertEquals("Not Found", responseLine.get("reason"));

    String stringContent = new String(response.getBody().get("content"), "UTF-8");
    assertThat(stringContent, containsString("404 File Not Found"));
  }

/*_________________________ 405 METHOD NOT ALLOWED ____________________________ */

  @Test public void F05MethodNotAllowed() throws IOException {
    response = factory.MethodNotAllowed();

    Hashtable<String, String> responseLine = response.getResponseLine();
    assertEquals("405", responseLine.get("code"));
    assertEquals("Method Not Allowed", responseLine.get("reason"));

    String stringContent = new String(response.getBody().get("content"), "UTF-8");
    assertThat(stringContent, containsString("Not Allowed"));
  }
}
