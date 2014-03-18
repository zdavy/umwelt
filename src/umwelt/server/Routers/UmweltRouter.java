/* src.umwelt.server.Routers */
package umwelt.server.Routers;

import umwelt.server.Communication.*;
import umwelt.server.Handlers.FOFHandler;
import umwelt.server.Handlers.GetHandler;
import umwelt.server.Handlers.PostHandler;

public class UmweltRouter implements iRouter {
  String method;

  public iResponse route(iRequest request){
    setMethod(request.method());
    return handle(request);
  };

  private iResponse handle(iRequest request){
    if (get()) {
      return GetHandler.handle(request);
    } else if (post()) {
      return PostHandler.handle(request);
    } else {
      return FOFHandler.handle(request);
    }
  }

  private boolean get() {
    return method.equals("get");
  }

  private boolean post() {
    return method.equals("post");
  }

  private void setMethod(String method){
    this.method = method;
  }
}
