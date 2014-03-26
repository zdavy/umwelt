package umwelt.server;

import java.util.ArrayList;
import java.util.Arrays;

import umwelt.server.Sockets.Server.iServerSocket;
import umwelt.server.Controllers.iController;
import umwelt.server.Handlers.UmweltHandler;
import umwelt.server.Responses.iFactory;
import umwelt.server.Routers.UmweltRouter;

public class Server {
  private ArrayList<iController> controllers;
  private iController[] allControllers;
  private iServerSocket serverSocket;
  private UmweltHandler handler;
  private UmweltRouter router;
  private iFactory factory;
  private String DIR = System.getProperty("user.dir");

  public Server(iServerSocket serverSocket) {
    controllers = new ArrayList<iController>();
    this.serverSocket = serverSocket;
  }

  public void addController(iController... controllers){
    this.controllers.addAll(Arrays.asList(controllers));
  }

  public void addResponseFactory(iFactory factory) {
    this.factory = factory;
  }

  public void changeDir(String dir) {
    DIR = dir;
  }

  public void addDir(String dir) {
    DIR = DIR + "/" + dir;
  }

  public void start() throws Exception {
    prepareServer();
    handler.start();
  }

  private void prepareServer() {
    lockControllers();
    generateRouter();
    generateHandler();
  }

  private void lockControllers() {
    allControllers = new iController[controllers.size()];
    controllers.toArray(allControllers);
  }

  private void generateRouter() {
    this.router = new UmweltRouter(allControllers, factory);
  }

  private void generateHandler() {
    handler = new UmweltHandler(serverSocket, router);
  }
}
