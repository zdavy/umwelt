package dasBoot.Responses;

public interface iFactory {
  public iResponse get() throws Exception;
  public iResponse FileNotFound() throws Exception;
  public iResponse MethodNotAllowed() throws Exception;
}
