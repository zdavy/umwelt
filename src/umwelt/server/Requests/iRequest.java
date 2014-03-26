package umwelt.server.Requests;

import java.io.InputStream;

public interface iRequest {
  public void read(InputStream input);
  public String method();
  public String uri();
}
