package dasMocks.Sockets.ServerSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import dasMocks.Sockets.Socket._Socket;

public class _ServerSocket extends ServerSocket {
  private boolean closed = false;

  public _ServerSocket(int _) throws IOException {
    close();
    closed = false;
  }

  @Override
  public Socket accept() throws IOException {
    return new _Socket();
  }

  @Override
  public boolean isClosed() {
    return closed;
  }

  @Override
    public void close() {
      closed = true;
    }
}
