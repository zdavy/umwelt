package mocks.Controllers;

import java.io.File;
import java.util.Hashtable;

import dasBoot.Controllers.iController;
import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;

import mocks.Responses._UmweltResponse;

public class _Controller implements iController {
  private Hashtable<String, iResponse> routes;
  private _UmweltResponse response = new _UmweltResponse();
  public String type;

  public _Controller(String type) {
    this.type = type;
    routes = new Hashtable<String, iResponse>();
  }

  public iResponse handle(iRequest request) {
    String code = (request.method().equals("GET")) ? "200" : "405";
    response.stubCode(code);
    return response;
  }

  public Hashtable<String, iResponse> getRoutes(){
    return routes;
  }

  public boolean valid(iRequest request) {
    boolean valid = new File(System.getProperty("user.dir") + request.uri()).exists();
    return valid;
  }

  public void stubResponse(_UmweltResponse stub) {
    response = stub;
  }

  public void stubRoute(String route, iResponse response){
    routes.put(route, response);
  }
}
