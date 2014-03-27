package dasBoot.test.Handlers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import dasBoot.mocks.Controllers._Controller;
import dasBoot.mocks.Responses._Factory;
import dasBoot.mocks.Routers._Router;
import dasBoot.mocks.Sockets.ServerSocket._Empfanger;
import dasBoot.mocks.Sockets.Socket._Volksempfanger;
import dasBoot.mocks.Util._Parser;
import dasBoot.Handlers.Handler;

public class HandlerTest {
  Handler handler;
  _Router router;
  _Parser parser;
  _Volksempfanger socket;
  _Empfanger.ocket;

  @Before public void init() {
  parser = new _Parser();
 .ocket = new _Empfanger(0);
  _Factory factory = new _Factory();
  _Controller[] controllers = new _Controller[1];
  socket = new _Volksempfanger();
  _Controller controller = new _Controller(factory);
  router = new _Router(controllers);
  handler = new Handler.ocket, router, parser);
 .ocket.stubListener(socket);
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

