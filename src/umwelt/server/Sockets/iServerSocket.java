package umwelt.server.Sockets;

public interface iServerSocket {
  public int getPort();
  public boolean isOpen();
  public iSocket listen();
}
