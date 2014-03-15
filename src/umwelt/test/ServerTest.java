package umwelt.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import umwelt.mocks.Routers._UmweltRouter;
import umwelt.mocks.Sockets._UmweltServerSocket;
import umwelt.server.Server;

import static org.junit.Assert.*;

public class ServerTest {
  int PORT = 3000;
  _UmweltServerSocket serverSocket;
  _UmweltRouter router;
  Server server;

  @Before public void before() {
    serverSocket = new _UmweltServerSocket(PORT);
    router = new _UmweltRouter();
    server = new Server(serverSocket, router);
  }

  @Test public void serverAssignsPropperPort() {
    assertEquals(PORT, server.getPort());
  }

  @Test public void serverStartsListeningForRequest() throws IOException {
    assertFalse(serverSocket.listening()); server.start();
    assertTrue(serverSocket.listening());
  }
}
