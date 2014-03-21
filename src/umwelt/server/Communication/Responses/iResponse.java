package umwelt.server.Communication.Responses;

import java.util.Hashtable;

import umwelt.server.Communication.Requests.iRequest;

public interface iResponse {
  public iResponse proccess(iRequest request);
  public Hashtable<String, String> getStatusLine();
  public Hashtable<String, String> getHeader();
  public Hashtable<String, byte[]> getBody();
}
