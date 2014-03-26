package umwelt.test.Sockets.Server;
import umwelt.server.Sockets.Server.UmweltServerSocket;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import umwelt.mocks.Sockets.Server._ServerSocket;
import umwelt.server.Sockets.Client.iSocket;

public class UmweltServerSocketTest {
  UmweltServerSocket serverSocket;

  @Before public void init() throws IOException {
    serverSocket = new UmweltServerSocket(3000);
    serverSocket.close();
    _ServerSocket fakeSocket = new _ServerSocket(3000);
    serverSocket.setServerSocket(fakeSocket);
  }

  @Test public void UmweltServerSocketIsOpenOnInitialization() throws IOException {
    assertTrue(serverSocket.isOpen());
    serverSocket.close();
    assertFalse(serverSocket.isOpen());
  }

  @Test public void UmweltServerListensWithClientSocket() throws IOException {
    iSocket socket = serverSocket.listen();
    assertNull(socket.request());
  }
}
