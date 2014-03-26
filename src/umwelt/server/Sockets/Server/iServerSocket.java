package umwelt.server.Sockets.Server;

import java.io.IOException;

import umwelt.server.Sockets.Client.iSocket;

public interface iServerSocket {
  public int getPort();
  public boolean isOpen();
  public iSocket listen() throws IOException;
}
