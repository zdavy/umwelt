package dasBoot.Requests;

public interface iRequest {
  public String method();
  public String uri();
  public String version();
  public int contentLength();
  public String body(String value);
  public String header(String value);
}
