package dasBoot.server.Sockets.ServerSocket;

import java.io.IOException;

import dasBoot.server.Sockets.Socket.iSocket;

public interface iServerSocket {
  public boolean isOpen();
  public iSocket listen() throws IOException;
}
