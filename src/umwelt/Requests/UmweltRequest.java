package umwelt.server.Requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

import dasBoot.Requests.iRequest;

public class UmweltRequest implements iRequest {
  private BufferedReader request;
  private Hashtable<String, String> requestLine = new Hashtable<String, String>();
  private Hashtable<String, String> header      = new Hashtable<String, String>();
  private Hashtable<String, String> body        = new Hashtable<String, String>();

  public UmweltRequest(InputStream input) throws IOException {
    request = read(input);
    assignRequestLine(nextLine().split("\\s"));
    assignHeader(nextLine());
    assignBody(new char[contentLength()]);
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
    return header.containsKey("Content-Length") ? getLength() : 0;
  }

  private int getLength() {
    return Integer.valueOf(header("Content-Length"));
  }

  private BufferedReader read(InputStream input) {
    return new BufferedReader(new InputStreamReader(input));
  }

  public String header(String value) {
    if(header.containsKey(value)) {
      return header.get(value);
    }
    else return null;
  }

  public String body(String value) {
    return body.get(value);
  }

  private void assignRequestLine(String[] line) throws IOException {
    setMethod(line[0]);
    setURI(line[1]);
    setVersion(line[2]);
  }

  private void setVersion(String version) {
    requestLine.put("version", version);
  }

  private void setMethod(String method) {
    requestLine.put("method", method);
  }

  private void setURI(String uri){
    try {
      String[] extraction = uri.split("\\?");
      requestLine.put("uri", extraction[0]);
      splitParameters(extraction[1]);
    } catch (ArrayIndexOutOfBoundsException e) {
      requestLine.put("uri", uri);
    }
  }

  private void assignHeader(String line) throws IOException {
    if(validHeader(line)) {
      addHeader(line.split(": "));
      assignHeader(nextLine());
    }
  }

  private String nextLine() throws IOException {
    return request.readLine();
  }

  private boolean validHeader(String header) {
    return (!(header == null) && (!header.equals("")));
  }

  private void addHeader(String[] headers) {
    header.put(headers[0], headers[1]);
  }

  private void assignBody(char[] content) throws IOException {
    if(hasContent(content)) {
      request.read(content);
      splitParameters(String.valueOf(content));
    }
  }

  private void splitParameters(String content) {
      for(String param: content.split("&")) {
        addBody(param.split("="));
      }
  }

  private void addBody(String[] param) {
    body.put(param[0], param[1]);
  }

  private boolean hasContent(char[] content) {
    return content.length > 0;
  }
}
