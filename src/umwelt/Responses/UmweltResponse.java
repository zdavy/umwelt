package umwelt.Responses;

import java.util.Hashtable;

import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;

public class UmweltResponse implements iResponse {
  private final String CRLF = "\r\n";
  private Hashtable<String, String> statusLine;
  private Hashtable<String, String> header;
  private Hashtable<String, byte[]> body;
  byte[] content;

  public UmweltResponse() {
    statusLine = new Hashtable<String, String>();
    header     = new Hashtable<String, String>();
    body       = new Hashtable<String, byte[]>();
  }

  public void setStatus(String code, String reason) {
    statusLine.put("code", code);
    statusLine.put("reason", reason);
  }

  private String status() {
    String code   = statusLine.get("code");
    String reason = statusLine.get("reason");
    return code + " " + reason;
  }

  public void setVersion(String version) {
    statusLine.put("version", version);
  }

  private String version() {
    return statusLine.get("version");
  }

  public void setHeader(String key, String value) {
    header.put(key, value);
  }

  public void setContent(String content){
    setContent(content.getBytes());
  }

  public void setContent(byte[] content){
    contentLength(Integer.toString(content.length));
    this.content = content;
    setBody(content);
  }

  public byte[] toByte() {
    String status = statusLineString();
    String header = headerString();
    byte[] response = (status + CRLF + header + CRLF).getBytes();
    if (body.get("content") == null) {
      return response;
    } else {
      return responseWithBody(response, body.get("content"));
    }
  }

  private byte[] responseWithBody(byte[] response, byte[] content){
    byte[] fullResponse = new byte[response.length + content.length];
    inject(fullResponse, response, content);
    return fullResponse;
  }

  private void inject(byte[] response, byte[] heading, byte[] body){
    System.arraycopy(heading, 0, response, 0, heading.length);
    System.arraycopy(body, 0, response, heading.length, body.length);
  }

  private String statusLineString() {
    return version() + " " + status();
  }

  private String headerString() {
    String headerString = "";
    for(String key : header.keySet()) {
      headerString += (key  + ": " + header.get(key) + CRLF);
    }
    return headerString;
  }

  public Hashtable<String, String> getResponseLine() {
    return statusLine;
  }

  public Hashtable<String, String> getHeader() {
    return header;
  }

  public Hashtable<String, byte[]> getBody() {
    return body;
  }

  private void contentLength(String length) {
    header.put("Content-Length", length);
  }

  private void setBody(byte[] content){
    body.put("content", content);
  }

  public iResponse proccess(iRequest request) {
    return this;
  }
}
