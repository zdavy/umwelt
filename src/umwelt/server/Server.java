/* src.umwelt.test.ServerTest  */
package umwelt.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import umwelt.server.Controllers.iController;
import umwelt.server.Handlers.RequestHandler;
import umwelt.server.Routers.UmweltRouter;
import umwelt.server.Routers.iRouter;
import umwelt.server.Sockets.Server.iServerSocket;

public class Server {
  private int port;
  private iServerSocket serverSocket;
  private ArrayList<iController> controllers = new ArrayList<iController>();
  private iRouter router;

  public Server(iServerSocket serverSocket) {
    this.serverSocket = serverSocket;
    setPort();
  }

  public int getPort() {
    return port;
  }

  public void addControllers(iController... controllers){
    this.controllers.addAll(Arrays.asList(controllers));
  }

  public void addController(iController controller){
    this.controllers.add(controller);
  }

  public void start() throws IOException {
    this.router = new UmweltRouter(controllers.toArray(new iController[controllers.size()]));
    RequestHandler handler = new RequestHandler(serverSocket, router);
    handler.start();
  }

  private void setPort() {
    this.port = serverSocket.getPort();
  }
}
