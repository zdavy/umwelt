package umwelt.server;

import java.io.IOException;

import dasBoot.Server;
import dasBoot.Sockets.ServerSocket.Empfanger;

public class UmweltServer extends Server {
  public UmweltServer(int port) throws IOException {
    super(new Empfanger(port));
  }
}
