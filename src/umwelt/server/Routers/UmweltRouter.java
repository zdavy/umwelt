/* src.umwelt.server.Routers */
package umwelt.server.Routers;

import umwelt.server.Communication.*;
import umwelt.server.Handlers.FOFHandler;
import umwelt.server.Handlers.FileHandler;
import umwelt.server.Handlers.GetHandler;
import umwelt.server.Handlers.PostHandler;

public class UmweltRouter implements iRouter {

  public iResponse route(iRequest request){
    return handle(request);
  };

  public void addRoute(String method, String uri, iResponse response) {
      if (method.equals("get")) {
        GetHandler.addRoute(uri, response);

      } else if (method.equals("post")) {
        PostHandler.addRoute(uri, response);

      } else {
        System.out.println("This Handler Doesn't Exist Yet :-)");
      }
  }

  private iResponse handle(iRequest request){
    String uri    = request.uri();
    String method = request.method();

    if (get(uri, method)) {
      return GetHandler.handle(request);

    } else if (file(uri)){
      return FileHandler.handle(request);

    } else if (post(uri, method)) {
      return PostHandler.handle(request);

    } else {
      return FOFHandler.handle(request);
    }
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
