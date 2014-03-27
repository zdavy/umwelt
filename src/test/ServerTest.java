package test;

import org.junit.*;
import static org.junit.Assert.*;

import test.Helpers.FileHelper;

import mocks.Sockets.Client._Volksempfanger;
import mocks.Sockets.Server._Empfanger;

import umwelt.UmweltServer;
import umwelt.Controllers.UmweltController;
import umwelt.Responses.UmweltFactory;
import umwelt.Responses.UmweltResponse;

public class ServerTest {
  UmweltServer server;
  UmweltController controller;
  _Volksempfanger socket;
  _Empfanger serverSocket;

  @Before public void init() throws Exception {
    socket = new _Volksempfanger();
    serverSocket = new _Empfanger(0000);
    server = new UmweltServer(serverSocket);
    controller = new UmweltController();
    serverSocket.stubListener(socket);
    server.addController(controller);
    server.addResponseFactory(new UmweltFactory(System.getProperty("user.dir")));
  }

  @Before public void stubFile() throws Exception {
    FileHelper.createFile("test.txt");
  }

  @After public void destubFile() {
    FileHelper.destroyFile("test.txt");
  }

  @Test public void ACCEPTANCE_TEST_200() throws Exception {
    UmweltResponse response = new UmweltResponse();
    response.setStatus("200", "OK");
    controller.get("/test.txt", response);
    String data = "GET /test.txt HTTP/1.1\r\nTest: Header\r\n";
    socket.stubInputStream(data);
    server.start();
    assertEquals("200", socket.response.getResponseLine().get("code"));
  }

  @Test public void ACCEPTANCE_TEST_405() throws Exception {
    controller.get("/test.txt", new UmweltResponse());
    String data = "POST /test.txt HTTP/1.1\r\nTest: Header\r\n";
    socket.stubInputStream(data);
    server.start();
    assertEquals("405", socket.response.getResponseLine().get("code"));
  }

  @Test public void ACCEPTANCE_TEST_404() throws Exception {
    String data = "POST /fail HTTP/1.1\r\nTest: Header\r\n";
    socket.stubInputStream(data);
    server.start();
    assertEquals("404", socket.response.getResponseLine().get("code"));
  }
}
