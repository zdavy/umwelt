package dasTest.Sockets.Socket;

import java.io.IOException;

import static org.junit.Assert.*;

import org.junit.Test;

import dasMocks.Responses._Response;
import dasMocks.Sockets.Socket._Socket;
import dasMocks.Util._Parser;
import dasBoot.Sockets.Socket.Volksempfanger;

public class VolksempfangerTest {
  @Test public void ReadsInputStreamFromSocket() throws IOException {
    _Socket socket = new _Socket();
    Volksempfanger volksempfanger = new Volksempfanger(socket);
    assertNull(volksempfanger.request(new _Parser()));
    assertTrue(socket.gotInputStream);
  }

  @Test public void writesOutputToSocket() throws Exception {
    _Socket socket = new _Socket();
    Volksempfanger volksempfanger = new Volksempfanger(socket);
    assertFalse(socket.gotOutputStream);
    volksempfanger.respondWith(new _Response());
    assertTrue(socket.gotOutputStream);
  }
}
