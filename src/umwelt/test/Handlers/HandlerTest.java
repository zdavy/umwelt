package umwelt.test.Handlers;
import umwelt.server.Handlers.UmweltHandler;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import umwelt.mocks.Sockets.Server._UmweltServerSocket;
import umwelt.mocks.Sockets.Client._UmweltSocket;
import umwelt.mocks.Controllers._Controller;
import umwelt.mocks.Routers._UmweltRouter;

public class HandlerTest {
  UmweltHandler handler;

  @Before public void init() {
    _UmweltServerSocket serverSocket = new _UmweltServerSocket(3000);
    _Controller[] controllers = new _Controller[1];
    _UmweltRouter router = new _UmweltRouter(controllers);
    controllers[0] = new _Controller("fake");

    handler = new UmweltHandler(serverSocket, router);
  }

  @Test public void handlerStartReturnsAClientSocket() throws Exception {
    assertNull(handler.clientSocket);
    handler.start();
    assertNotNull(handler.clientSocket);
  }

  @Test public void handlerClosesClientSocketWhenDone() throws Exception {
    _UmweltSocket clientSocket = new _UmweltSocket();
    handler.interact(clientSocket);
    assertTrue(clientSocket.socketClosed);
  }

  @Test public void handlerGetsRequestAndSendsResponse() throws Exception {
    _UmweltSocket clientSocket = new _UmweltSocket();
    handler.interact(clientSocket);
    assertTrue(clientSocket.requestMade);
    assertTrue(clientSocket.responseSent);
  }
}
