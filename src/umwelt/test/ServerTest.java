package umwelt.test;

import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;

import dasBoot.Server;

import umwelt.mocks.Controllers._Controller;
import umwelt.mocks.Sockets.Client._UmweltSocket;
import umwelt.mocks.Sockets.Server._UmweltServerSocket;
import umwelt.server.Responses.UmweltFactory;

import static org.junit.Assert.*;

public class ServerTest {
  Hashtable<String, String> responseLine;
  _UmweltServerSocket serverSocket;
  _UmweltSocket socket;
  int PORT = 3000;
  Server server;

  public void interact() throws Exception {
    server.start();
    responseLine = socket.response.getResponseLine();
  }

  @Before public void init() throws Exception {
    serverSocket = new _UmweltServerSocket(PORT);
    server = new Server(serverSocket);
    socket = new _UmweltSocket();
    server.addController(new _Controller("test"));
    server.addResponseFactory(new UmweltFactory(System.getProperty("user.dir")));
    serverSocket.stubListener(socket);
  }

  @Test public void ACCEPTANCE_TEST_200() throws Exception {
    socket.stubRequest("GET /test/test.txt HTTP/1.1\r\nTest: Header\r\n");
    interact();
    assertEquals("200", responseLine.get("code"));
  }

  @Test public void ACCEPTANCE_TEST_404() throws Exception {
    socket.stubRequest("GET /test/test.fake HTTP/1.1\r\nTest: Header\r\n");
    interact();
    assertEquals("404", responseLine.get("code"));
  }

  @Test public void ACCEPTANCE_TEST_405() throws Exception {
    socket.stubRequest("PUT /test/test.txt HTTP/1.1\r\nTest: Header\r\n");
    interact();
    assertEquals("405", responseLine.get("code"));
  }
}
