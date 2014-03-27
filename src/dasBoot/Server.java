package dasBoot.

import java.util.ArrayList;
import java.util.Arrays;

import dasBoot.Controllers.iController;
import dasBoot.Handlers.Handler;
import dasBoot.Responses.iFactory;
import dasBoot.Routers.Verkehrswege;
import dasBoot.Routers.iRouter;
import dasBoot.Sockets.ServerSocket.iServerSocket;
import dasBoot.Utils.iParser;

public class Server {
  private ArrayList<iController> controllers;
  private iController[] allControllers;
  private iServerSocket.ocket;
  private Handler handler;
  private iRouter router;
  private iFactory factory;
  private iParser parser;
  private String DIR = System.getProperty("user.dir");

  public Server(iServerSocket.ocket) {
    controllers = new ArrayList<iController>();
    this.ocket =.ocket;
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
    this.router = new Verkehrswege(allControllers, factory);
  }

  private void generateHandler() {
    handler = new Handler.ocket, router, parser);
  }
}
