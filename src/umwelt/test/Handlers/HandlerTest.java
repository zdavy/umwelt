/* src.umwelt.server.Handlers.UmweltHandler */
package umwelt.test.Handlers;

import java.io.IOException;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

import umwelt.mocks.Routers._UmweltRouter;
import umwelt.mocks.Sockets.Client._UmweltSocket;
import umwelt.mocks.Sockets.Server._UmweltServerSocket;
import umwelt.server.Handlers.UmweltHandler;

public class HandlerTest {
  UmweltHandler handler;

  @Before public void init() {
    _UmweltServerSocket serverSocket = new _UmweltServerSocket(3000);
    _UmweltRouter router = new _UmweltRouter();
    handler = new UmweltHandler(serverSocket, router);
  }

  @Test public void handlerStartReturnsAClientSocket() throws IOException {
    assertNull(handler.clientSocket);
    handler.start();
    assertNotNull(handler.clientSocket);
  }

  @Test public void handlerClosesClientSocketWhenDone() throws IOException {
    _UmweltSocket clientSocket = new _UmweltSocket();
    handler.interact(clientSocket);
    assertTrue(clientSocket.socketClosed);
  }

  @Test public void handlerGetsRequestAndSendsResponse() throws IOException {
    _UmweltSocket clientSocket = new _UmweltSocket();
    handler.interact(clientSocket);
    assertTrue(clientSocket.requestMade);
    assertTrue(clientSocket.responseSent);
  }
}
