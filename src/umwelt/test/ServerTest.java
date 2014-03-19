/* src.umwelt.server.Server; */
package umwelt.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import umwelt.mocks.Sockets._UmweltServerSocket;
import umwelt.server.Server;
import umwelt.server.Handlers.iResponseHandler;

import static org.junit.Assert.*;

public class ServerTest {
  int PORT = 3000;
  _UmweltServerSocket serverSocket;
  iResponseHandler[] handlers;
  Server server;

  @Before public void before() {
    serverSocket = new _UmweltServerSocket(PORT);
    server = new Server(serverSocket);
  }

  @Test public void serverAssignsPropperPort() {
    assertEquals(PORT, server.getPort());
  }

  @Test public void serverStartsListeningForRequest() throws IOException {
    assertFalse(serverSocket.listening());
    server.start();
    assertTrue(serverSocket.listening());
  }
}
