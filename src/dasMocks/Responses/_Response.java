package dasMocks.Responses;
import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;

import java.util.Hashtable;

public class _Response implements iResponse {
  private String code;

  public Hashtable<String, String> getResponseLine() {
    Hashtable<String, String>responseLine = new Hashtable<String, String>();
    responseLine.put("code", code);
    return responseLine;
  }

  public void stubCode(String code) {
    this.code = code;
  }

  public _Response() {  }
  public void setContent(byte[] content) {  }
  public void setContent(String content) {  }
  public void setVersion(String version) {  }
  public void setHeader(String key, String value) {  }
  public void setStatus(String method, String uri) {  }
  public Hashtable<String, byte[]> getBody() { return null; }
  public _Response proccess(iRequest request) { return this; }
  public Hashtable<String, String> getHeader() { return null; }
  public byte[] toByte() throws Exception { return new byte[0]; }
}
