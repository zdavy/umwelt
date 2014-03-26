package umwelt.server.Utils;

import java.io.InputStream;

import umwelt.server.Requests.iRequest;

public interface iParser {
  public iRequest request(InputStream input);
}
