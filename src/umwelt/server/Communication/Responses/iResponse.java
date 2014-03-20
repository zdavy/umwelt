package umwelt.server.Communication.Responses;

import umwelt.server.Communication.Requests.iRequest;

public interface iResponse {
  public iResponse proccess(iRequest request);
}
