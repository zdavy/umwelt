package umwelt.test.Handlers;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import umwelt.mocks.Routers._UmweltRouter;
import umwelt.mocks.Sockets._UmweltServerSocket;
import umwelt.mocks.Sockets._UmweltSocket;
import umwelt.server.Handlers.RequestHandler;

public class RequestHandlerTest {
  RequestHandler handler;

  @Before public void init() {
    _UmweltServerSocket serverSocket = new _UmweltServerSocket(3000);
    _UmweltRouter router = new _UmweltRouter();
    handler = new RequestHandler(serverSocket, router);
  }

  @Test public void handlerStartReturnsAClientSocket() {
    assertNull(handler.clientSocket);
    handler.start();
    assertNotNull(handler.clientSocket);
  }

  @Test public void handlerClosesClientSocketWhenDone() {
    handler.start();
    assertFalse(handler.clientSocket.isOpen());
  }

  @Test public void handlerGetsRequestAndSendsResponse() {
    _UmweltSocket clientSocket = new _UmweltSocket();
    handler.interact(clientSocket);
    assertTrue(clientSocket.requestMade);
    assertTrue(clientSocket.responseSent);
  }
}
