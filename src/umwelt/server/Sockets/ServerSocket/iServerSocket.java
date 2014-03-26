package umwelt.server.Sockets.ServerSocket;

import java.io.IOException;

import umwelt.server.Sockets.Socket.iSocket;

public interface iServerSocket {
  public boolean isOpen();
  public iSocket listen() throws IOException;
}
