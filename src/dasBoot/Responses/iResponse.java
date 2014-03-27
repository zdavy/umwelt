package dasBoot.Responses;

import java.util.Hashtable;

import dasBoot.Requests.iRequest;

public interface iResponse {
  public byte[] toByte() throws Exception;
  public iResponse proccess(iRequest request);

  public Hashtable<String, String> getResponseLine();
  public Hashtable<String, String> getHeader();
  public Hashtable<String, byte[]> getBody();

  public void setHeader(String key, String value);
  public void setStatus(String code, String reason);
  public void setVersion(String version);
  public void setContent(byte[] content);
  public void setContent(String content);
}
