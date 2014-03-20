package umwelt.server.Communication.Responses;

import umwelt.server.Communication.Requests.iRequest;

public class UmweltResponse implements iResponse {
  public UmweltResponse() {
  }

  public iResponse proccess(iRequest request) {
    return this;
  }
}
