package test.Requests;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.*;

import umwelt.Requests.UmweltRequest;
import umwelt.Util.UmweltParser;

import static org.junit.Assert.*;


public class UmweltRequestTest {
  UmweltRequest request;

  @Before public void init() {
    ByteArrayInputStream input;
    String data;
    data = "GET / HTTP/1.1\r\n" +
           "Test: Header\r\n" +
           "Content-Length: 19\r\n\r\ndata=test&more=data";
    input = new ByteArrayInputStream(data.getBytes(Charset.forName("utf-8")));
    request = new UmweltParser().request(input);
  }

  @Test public void requestParsesRequestLine() {
    assertEquals("GET", request.method());
    assertEquals("/", request.uri());
    assertEquals("HTTP/1.1", request.version());
  }

  @Test public void requestParsesHeaders() {
    assertEquals("Header", request.header("Test"));
    assertEquals(19, request.contentLength());
  }

  @Test public void requestParsesBody() {
    assertEquals("test", request.body("data"));
    assertEquals("data", request.body("more"));
  }

  @Test public void ItParsesTheParamsFromTheURL() throws IOException {
    String data = "GET /test?params=true HTTP/1.1\r\n" +
           "Test: Header\r\n";
    ByteArrayInputStream input;
    input = new ByteArrayInputStream(data.getBytes(Charset.forName("utf-8")));
    request = new UmweltParser().request(input);
    assertEquals("/test", request.uri());
    assertEquals("true", request.body("params"));
  }
}
