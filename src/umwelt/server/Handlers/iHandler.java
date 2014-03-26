package umwelt.server.Handlers;

import umwelt.server.Sockets.Socket.iSocket;

public interface iHandler {
  public void start() throws Exception;
  public void interact(iSocket socket) throws Exception;
}
