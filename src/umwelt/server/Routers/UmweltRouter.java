/* src.umwelt.test.Routers.UmweltRouterTest */
package umwelt.server.Routers;

import umwelt.server.Communication.*;
import umwelt.server.Handlers.iResponseHandler;

public class UmweltRouter implements iRouter {
  iResponseHandler[] handlers;

  public UmweltRouter(iResponseHandler... handlers) {
    this.handlers = handlers;
  }

  public iResponse route(iRequest request){
    return handle(request);
  };

  public void addRoute(String method, String uri, iResponse response) {
      iResponseHandler handler = determineHandler(method);
      if(handler == null) {
        System.out.println("That Handler Doesn't Exist Yet :-)");
      } else {
      handler.addRoute(uri, response);
    }
  }

  private iResponseHandler determineHandler(String method) {
    for(iResponseHandler handler : handlers) {
      if(handler.type().equals(method)) {
        return handler;
      }
    }
    return null;
  }

  private iResponseHandler determineHandler(iRequest request) {
    for(iResponseHandler handler : handlers) {
      if(handler.valid(request)) {
        return handler;
      }
    }
    return null;
  }

  private iResponse handle(iRequest request){
    iResponseHandler handler = determineHandler(request);
    if(handler == null) {
      return new FOFResponse();
    }
    return handler.handle(request);
  }
}
