package umwelt.test.Handlers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import umwelt.mocks.Controllers._Controller;
import umwelt.mocks.Responses._Factory;
import umwelt.mocks.Routers._Router;
import umwelt.mocks.Sockets.ServerSocket._Empfanger;
import umwelt.mocks.Sockets.Socket._Volksempfanger;
import umwelt.mocks.Util._Parser;
import umwelt.server.Handlers.Handler;

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

