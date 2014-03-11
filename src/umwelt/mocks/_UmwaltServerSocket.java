package umwelt.mocks;

import umwelt.server.Sockets.iServerSocket;

public class _UmwaltServerSocket implements iServerSocket {
  private int port;
  private boolean listen = false;

  public _UmwaltServerSocket(int port) { this.port = port; }
  public boolean listening() { return listen; }
  public void listen() { listen = true; }
  public int getPort() { return port; }
}
