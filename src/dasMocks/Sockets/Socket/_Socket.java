package dasMocks.Sockets.Socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class _Socket extends Socket {
  public boolean gotInputStream = false;
  public boolean gotOutputStream = false;

  public _Socket() throws IOException {
    this.close();
  }

  @Override
  public InputStream getInputStream() {
    gotInputStream = true;
    return null;
  }

  @Override
  public OutputStream getOutputStream() {
    gotOutputStream = true;
    return new ByteArrayOutputStream();
  }
}
