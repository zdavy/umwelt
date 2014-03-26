package umwelt.test.Sockets.Socket;

import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class VolksempfangerTest {
  @Test public void ReadsInputStreamFromSocket() throws IOException {
    _Socket socket = new _Socket();
    Volksempfanger volksempfanger = new Volksempfanger(socket);
    assertNull(volksempfanger.request());
    assertTrue(socket.gotInputStream);
  }

  @Test public void writesOutputToSocket() throws Exception {
    _Socket socket = new _Socket();
    Volksempfanger volksempfanger = new Volksempfanger(socket);
    assertFalse(socket.gotOutputStream);
    volksempfanger.respondWith(new _UmweltResponse());
    assertTrue(socket.gotOutputStream);
  }
}
