package dasBoot.server.Utils;

import java.io.InputStream;

import dasBoot.server.Requests.iRequest;

public interface iParser {
  public iRequest request(InputStream input);
}
