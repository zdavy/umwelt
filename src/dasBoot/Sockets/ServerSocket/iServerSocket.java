package dasBoot.Sockets.ServerSocket;

import java.io.IOException;

import dasBoot.Sockets.Socket.iSocket;

public interface iServerSocket {
  public boolean isOpen();
  public iSocket listen() throws IOException;
}
