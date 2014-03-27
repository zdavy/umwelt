package dasBoot.Utils;

import java.io.InputStream;

import dasBoot.Requests.iRequest;

public interface iParser {
  public iRequest request(InputStream input);
}
