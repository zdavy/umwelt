package umwelt.Requests;

import java.util.Hashtable;

import dasBoot.Requests.iRequest;

public class UmweltRequest implements iRequest {
  private Hashtable<String, String> requestLine = new Hashtable<String, String>();
  private Hashtable<String, String> header      = new Hashtable<String, String>();
  private Hashtable<String, String> body        = new Hashtable<String, String>();

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

  public String header(String value) {
    if(header.containsKey(value)) {
      return header.get(value);
    }
    else return null;
  }

  public String body(String value) {
    if(body.containsKey(value)) {
      return body.get(value);
    }
    else return null;
  }

  public void setVersion(String version) {
    requestLine.put("version", version);
  }

  public void setMethod(String method) {
    requestLine.put("method", method);
  }

  public void setURI(String uri) {
    requestLine.put("uri", uri);
  }

  public void setBody(String[] param) {
    body.put(param[0], param[1]);
  }

  public void addHeader(String[] headers) {
    header.put(headers[0], headers[1]);
  }

  private int getLength() {
    return Integer.valueOf(header("Content-Length"));
  }
}
