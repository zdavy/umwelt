package dasTest.Handlers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import dasMocks.Controllers._Controller;
import dasMocks.Responses._Factory;
import dasMocks.Routers._Router;
import dasMocks.Sockets.ServerSocket._Empfanger;
import dasMocks.Sockets.Socket._Volksempfanger;
import dasMocks.Util._Parser;
import dasBoot.Handlers.Handler;

public class HandlerTest {
  Handler handler;
  _Router router;
  _Parser parser;
  _Volksempfanger socket;
  _Empfanger serverSocket;

  @Before public void init() {
  parser = new _Parser();
  serverSocket = new _Empfanger(0);
  _Factory factory = new _Factory();
  _Controller[] controllers = new _Controller[1];
  socket = new _Volksempfanger();
  _Controller controller = new _Controller(factory);
  router = new _Router(controllers);
  handler = new Handler(serverSocket, router, parser);
  serverSocket.stubListener(socket);
  controllers[0] = controller;
  }

  @Test public void AppropriateAlogrithmCalled() throws Exception {
    handler.start();
    assertTrue(socket.wasRequested);
    assertTrue(router.wasRouted);
    assertTrue(socket.wasResponded);
    assertTrue(socket.wasClosed);
  }
}
