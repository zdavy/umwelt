package umwelt.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import umwelt.mocks._UmwaltServerSocket;
import umwelt.server.Server;

public class ServerTest {
  int PORT = 3000;
  Server server;
  _UmwaltServerSocket serverSocket;

  @Before
  public void before() {
    serverSocket = new _UmwaltServerSocket(PORT);
    server = new Server(serverSocket);
  }

  @Test
  public void serverAssignsPropperPort() {
    assertEquals(PORT, server.getPort());
  }

  @Test
  public void serverStartsListeningForRequest() {
    assertFalse(serverSocket.listening());
    server.start();
    assertTrue(serverSocket.listening());
  }
}
