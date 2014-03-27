package dasTest.Sockets.ServerSocket;

import java.io.IOException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dasMocks.Sockets.ServerSocket._ServerSocket;
import dasMocks.Util._Parser;
import dasBoot.Sockets.ServerSocket.Empfanger;
import dasBoot.Sockets.Socket.iSocket;

public class EmpfangerTest {
  Empfanger empfanger;

  @Before public void init() throws IOException {
    empfanger = new Empfanger(3000);
    empfanger.close();
    _ServerSocket serverSocket = new _ServerSocket(3000);
    empfanger.setServerSocket(serverSocket);
  }

  @Test public void EmpfangerIsOpenOnInitialization() throws IOException {
    assertTrue(empfanger.isOpen());
    empfanger.close();
    assertFalse(empfanger.isOpen());
  }

  @Test public void UmweltServerListensWithClientSocket() throws IOException {
    iSocket socket = empfanger.listen();
    assertNull(socket.request(new _Parser()));
  }
}
