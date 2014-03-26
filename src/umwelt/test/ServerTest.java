package umwelt.test;

import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServerTest {
  Hashtable<String, String> responseLine;
  _Empfanger serverSocket;
  _Volksempfanger socket;
  int PORT = 3000;
  Server server;

  public void interact() throws Exception {
    server.start();
    responseLine = socket.response.getResponseLine();
  }

  @Before public void init() throws Exception {
    serverSocket = new _Empfanger(PORT);
    server = new Server(serverSocket);
    socket = new _Volksempfanger();
    server.addController(new _Controller("test"));
    serverSocket.stubListener(socket);
  }

  @Test public void ACCEPTANCE_TEST_200() throws Exception {
    socket.stubRequest("GET /test.txt HTTP/1.1\r\nTest: Header\r\n");
    interact();
    assertEquals("200", responseLine.get("code"));
  }

  @Test public void ACCEPTANCE_TEST_404() throws Exception {
    socket.stubRequest("GET /test.fake HTTP/1.1\r\nTest: Header\r\n");
    interact();
    assertEquals("404", responseLine.get("code"));
  }

  @Test public void ACCEPTANCE_TEST_405() throws Exception {
    socket.stubRequest("PUT /test.txt HTTP/1.1\r\nTest: Header\r\n");
    interact();
    assertEquals("405", responseLine.get("code"));
  }
}
