package umwelt.test.Sockets.Client;
import umwelt.server.Sockets.Client.UmweltSocket;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

import umwelt.mocks.Communication.Responses._UmweltResponse;
import umwelt.mocks.Sockets.Client._Socket;

public class UmweltSocketTest {
  @Test public void ReadsInputStreamFromSocket() throws IOException {
    _Socket fakeSocket = new _Socket();
    UmweltSocket socket = new UmweltSocket(fakeSocket);
    assertNull(socket.request());
    assertTrue(fakeSocket.gotInputStream);
  }

  @Test public void writesOutputToSocket() throws Exception {
    _Socket fakeSocket = new _Socket();
    UmweltSocket socket = new UmweltSocket(fakeSocket);
    assertFalse(fakeSocket.gotOutputStream);
    socket.respondWith(new _UmweltResponse());
    assertTrue(fakeSocket.gotOutputStream);
  }
}
