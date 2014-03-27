package mocks.Responses;

import java.util.Hashtable;

import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;

public class _UmweltResponse implements iResponse {
  private String code = "200";

  public Hashtable<String, String> getResponseLine() {
    Hashtable<String, String>responseLine = new Hashtable<String, String>();
    responseLine.put("code", code);
    return responseLine;
  }

  public void stubCode(String code) {
    this.code = code;
  }

  public String code() {
    return code;
  }

  public Hashtable<String, String> getHeader() {
    return null;
  }
  public Hashtable<String, byte[]> getBody() {
    return null;
  }
  public _UmweltResponse() {
  }

  public byte[] toByte() throws Exception {
    return new byte[0];
  }

  public void setContent(byte[] content) {  }
  public void setContent(String content) {  }
  public void setVersion(String version) {  }
  public void setHeader(String key, String value) {  }
  public void setStatus(String method, String uri) {  }

  public _UmweltResponse proccess(iRequest request) {
    return this;
  }
}
