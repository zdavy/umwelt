package umwelt.server.Communication.Responses;

import java.util.Hashtable;

import umwelt.server.Communication.Requests.iRequest;

public class UmweltResponse implements iResponse {
  private Hashtable<String, String> statusLine;
  private Hashtable<String, String> header;
  private Hashtable<String, String> body;

  public UmweltResponse() {
    statusLine = new Hashtable<String, String>();
    header = new Hashtable<String, String>();
    body = new Hashtable<String, String>();
  }

  public void status(String code, String reason) {
    statusLine.put("code", code);
    statusLine.put("reason", reason);
  }

  public void uri(String uri) {
    statusLine.put("uri", uri);
  }

  public void version(String version) {
    statusLine.put("version", version);
  }

  public void header(String key, String value) {
    header.put(key, value);
  }

  public void setContent(String content){
    setContent(content.getBytes());
  }

  public void setContent(byte[] content){
    contentLength(Integer.toString(content.length));
    setBody(content.toString());
  }

  public Hashtable<String, String> getResponseLine() {
    return statusLine;
  }

  public Hashtable<String, String> getHeader() {
    return header;
  }

  public Hashtable<String, String> getBody() {
    return body;
  }

  private void contentLength(String length) {
    header.put("Content-Length", length);
  }

  private void setBody(String content){
    body.put("content", content);
  }

  public iResponse proccess(iRequest request) {
    return this;
  }
}
