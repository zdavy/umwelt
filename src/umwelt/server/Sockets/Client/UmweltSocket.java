package umwelt.server.Sockets.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import umwelt.server.Requests.UmweltRequest;
import umwelt.server.Responses.iResponse;

public class UmweltSocket implements iSocket {
  private Socket socket;

  public UmweltSocket(Socket clientSocket) throws IOException {
    this.socket = clientSocket;
  }

  public UmweltRequest request() throws IOException {
    InputStream input = socket.getInputStream();
    return invalid(input) ? null : new UmweltRequest(input);
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
