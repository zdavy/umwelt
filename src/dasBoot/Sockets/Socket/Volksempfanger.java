package dasBoot.Sockets.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import dasBoot.Requests.iRequest;
import dasBoot.Responses.iResponse;
import dasBoot.Utils.iParser;

public class Volksempfanger implements iSocket {
  private Socket socket;

  public Volksempfanger(Socket clientSocket) throws IOException {
    this.socket = clientSocket;
  }

  public iRequest request(iParser parser) throws IOException {
    InputStream input = socket.getInputStream();
    return invalid(input) ? null : parser.request(input);
  }

  private boolean invalid(InputStream input) {
    return (input == null) || input.equals("");
  }

  public void respondWith(iResponse response) throws Exception {
    OutputStream outputStream = socket.getOutputStream();
    byte[] output = response.toByte();
    outputStream.write(output);
  }

  public void close() throws IOException {
    socket.close();
  }
}
