package umwelt.server.Communication.Responses;

import umwelt.server.Communication.Requests.iRequest;

public class FOFResponse implements iResponse {
  public String type = "404";

  public iResponse proccess(iRequest request) {
    return this;
  }
}
