/* src.umwelt.server.Routers */
package umwelt.server.Routers;

import umwelt.server.Communication.*;
import umwelt.server.Handlers.FOFHandler;
import umwelt.server.Handlers.FileHandler;
import umwelt.server.Handlers.GetHandler;
import umwelt.server.Handlers.PostHandler;
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
      handler.addRoute(uri, response);
  }
  /*     if (method.equals("get")) { */
  /*       GetHandler.addRoute(uri, response); */
  /*  */
  /*     } else if (method.equals("post")) { */
  /*       PostHandler.addRoute(uri, response); */
  /*  */
  /*     } else { */
  /*       System.out.println("This Handler Doesn't Exist Yet :-)"); */
  /*     } */
  /* } */

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
    return handler.handle(request);
    /* if (get(uri, method)) { */
    /*   return GetHandler.handle(request); */
    /*  */
    /* } else if (file(uri)){ */
    /*   return FileHandler.handle(request); */
    /*  */
    /* } else if (post(uri, method)) { */
    /*   return PostHandler.handle(request); */
    /*  */
    /* } else { */
    /*   return FOFHandler.handle(request); */
    /* } */
  }

  private boolean get(String uri, String method) {
    return (GetHandler.routes.containsKey(uri) && method.equals("get")) ;
  }

  private boolean file(String uri) {
    return FileHandler.exists(uri);
  }

  private boolean post(String uri, String method) {
    return (PostHandler.routes.containsKey(uri) && method.equals("get")) ;
  }
}
