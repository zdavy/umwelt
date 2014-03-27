package dasTest;

import java.io.File;
import java.io.PrintWriter;
import java.util.Hashtable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dasMocks.Controllers._Controller;
import dasMocks.Responses._Factory;
import dasMocks.Sockets.ServerSocket._Empfanger;
import dasMocks.Sockets.Socket._Volksempfanger;
import dasBoot.Server;
import dasTest.Helpers.FileHelper;

import static org.junit.Assert.*;

public class ServerTest {
  Hashtable<String, String> responseLine;
  _Controller controller;
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
    _Factory factory = new _Factory();
    controller = new _Controller(factory);
    server.addController(controller);
    serverSocket.stubListener(socket);
    server.addResponseFactory(factory);
    FileHelper.createFile("test.txt");
  }

  @After public void denit() {
    FileHelper.destroyFile("test.txt");
  }

  @Test public void ACCEPTANCE_TEST_200() throws Exception {
    socket.stubRequest("get", "/test.txt");
    controller.stubMethodExists(true);
    interact();
    assertEquals("200", responseLine.get("code"));
  }

  @Test public void ACCEPTANCE_TEST_405() throws Exception {
    socket.stubRequest("put", "/test.txt");
    interact();
    assertEquals("405", responseLine.get("code"));
  }

  @Test public void ACCEPTANCE_TEST_404() throws Exception {
    socket.stubRequest("get", "/toast.txt");
    interact();
    assertEquals("404", responseLine.get("code"));
  }
}
