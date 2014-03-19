/* src.umwelt.test.ServerTest  */
package umwelt.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import umwelt.server.Handlers.RequestHandler;
import umwelt.server.Handlers.iResponseHandler;
import umwelt.server.Routers.UmweltRouter;
import umwelt.server.Routers.iRouter;
import umwelt.server.Sockets.iServerSocket;

public class Server {
  private int port;
  private iServerSocket serverSocket;
  private ArrayList<iResponseHandler> handlers = new ArrayList<iResponseHandler>();
  private iRouter router;

  public Server(iServerSocket serverSocket) {
    this.serverSocket = serverSocket;
    setPort();
  }

  public int getPort() {
    return port;
  }

  public void addHandlers(iResponseHandler... handlers){
    this.handlers.addAll(Arrays.asList(handlers));
  }

  public void addHandler(iResponseHandler handler){
    this.handlers.add(handler);
  }

  public void start() throws IOException {
    this.router = new UmweltRouter(handlers.toArray(new iResponseHandler[handlers.size()]));
    RequestHandler handler = new RequestHandler(serverSocket, router);
    handler.start();
  }

  private void setPort() {
    this.port = serverSocket.getPort();
  }
}
