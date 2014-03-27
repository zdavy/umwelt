package umwelt;

import java.io.IOException;

import umwelt.Util.UmweltParser;

import dasBoot.Server;
import dasBoot.Sockets.ServerSocket.Empfanger;
import dasBoot.Sockets.ServerSocket.iServerSocket;

public class UmweltServer extends Server {

  public UmweltServer(int port) throws IOException {
    super(new Empfanger(port));
    parser = new UmweltParser();
  }

  public UmweltServer(iServerSocket socket) {
    super(socket);
    parser = new UmweltParser();
  }

  public void close() throws IOException {
    this.serverSocket.close();
  }
}

