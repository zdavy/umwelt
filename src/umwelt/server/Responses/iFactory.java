package umwelt.server.Responses;

public interface iFactory {
  public iResponse FileNotFound() throws Exception;
  public iResponse MethodNotAllowed() throws Exception;
}
