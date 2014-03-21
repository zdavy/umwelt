package umwelt.test.Communication.Responses;

import java.io.IOException;
import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;

import umwelt.mocks.Communication.Requests._UmweltRequest;
import umwelt.server.Communication.Responses.ResponseFactory;
import umwelt.server.Communication.Responses.iResponse;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class ResponseFactoryTest {
  ResponseFactory factory;
  String DIR = System.getProperty("user.dir") + "/test";
  iResponse response;
  _UmweltRequest request;

  @Before public void init() throws IOException {
    factory = new ResponseFactory();
    request  = new _UmweltRequest();
  }

/*______________________________ FILE RESPONSE ______________________________ */
  @Test public void FILE_RESPONSE__getsTheFileResponseStatus() throws IOException {
    request.stubURI("/test.txt");
    response = factory.file(DIR, request);

    Hashtable<String, String> statusLine = response.getStatusLine();
    assertEquals("200", statusLine.get("code"));
    assertEquals("OK", statusLine.get("reason"));
    assertEquals("HTTP/1.1", statusLine.get("version"));
  }

  @Test public void FILE_RESPONSE__getsTheFileResponseHeader() throws IOException {
    request.stubURI("/test.txt");
    response = factory.file(DIR, request);

    Hashtable<String, String> header = response.getHeader();
    assertEquals("0", header.get("Content-Length"));
  }

  @Test public void FILE_RESPONSE__getsTheFileResponseBody() throws IOException {
    request.stubURI("/test.txt");
    response = factory.file(DIR, request);

    Hashtable<String, byte[]> body = response.getBody();
    assertThat(body.get("content"), instanceOf(byte[].class));
  }
}
