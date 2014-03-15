package umwelt.server.Communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class UmweltRequest {
  private BufferedReader request;
  private Hashtable<String, String> requestLine = new Hashtable<String, String>();
  private Hashtable<String, String> header = new Hashtable<String, String>();
  private Hashtable<String, String> body = new Hashtable<String, String>();

  public UmweltRequest(InputStream input) throws IOException {
    request = parse(input);
    assignRequestLine();
    assignHeaders();
    assignBody();
  }

  public String method() {
    return requestLine.get("method");
  }

  public String uri() {
    return requestLine.get("uri");
  }

  public String version() {
    return requestLine.get("version");
  }

  public int contentLength() {
    return Integer.parseInt(String.valueOf(header("Content-Length")));
  }

  private BufferedReader parse(InputStream input) {
    return new BufferedReader(new InputStreamReader(input));
  }

  public String header(String value) {
    return header.get(value);
  }

  public String body(String value) {
    return body.get(value);
  }

  private void assignRequestLine() throws IOException {
    String[] options;
    options = request.readLine().split("\\s");
    requestLine.put("method", options[0]);
    requestLine.put("uri", options[1]);
    requestLine.put("version", options[2]);
  }

  private void assignHeaders() throws IOException {
    String[] values;
    String headers = request.readLine();
    while(!headers.equals("")) {
      values = headers.split(": ");
      header.put(values[0], values[1]);
      headers = request.readLine();
    }
  }

  private void assignBody() throws IOException {
    char[] content = new char[contentLength()];
    request.read(content);
    String concat = String.valueOf(content);
    String[] params = concat.split("&");
    for(String param: params) {
      String[] values = param.split("=");
      body.put(values[0], values[1]);
    }
  }
}
