package umwelt.server;

import java.util.ArrayList;
import java.util.Arrays;

import umwelt.server.Controllers.iController;
import umwelt.server.Handlers.Handler;
import umwelt.server.Responses.iFactory;
import umwelt.server.Routers.iRouter;
import umwelt.server.Sockets.ServerSocket.iServerSocket;
import umwelt.server.Utils.iParser;

public class Server {
  private ArrayList<iController> controllers;
  private iController[] allControllers;
  private iServerSocket serverSocket;
  private Handler handler;
  private iRouter router;
  private iFactory factory;
  private iParser parser;
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

  public void addDir(String dir) {
    DIR = DIR + "/" + dir;
  }

  public void changeDir(String dir) {
    DIR = dir;
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
    this.router = new Router(allControllers, factory);
  }

  private void generateHandler() {
    handler = new Handler(serverSocket, router, parser);
  }
}
