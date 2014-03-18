/* src.umwelt.server.Handlers.GetHandler */
package umwelt.test.Handlers;

import org.junit.Test;

import umwelt.mocks.Communication._UmweltRequest;
import umwelt.mocks.Communication._UmweltResponse;
import umwelt.server.Handlers.GetHandler;

import static org.junit.Assert.*;

public class GetHandlerTest {
  @Test public void responseIsProccessedWithRequestData() {
    GetHandler.addRoute("/test", new _UmweltResponse());
    _UmweltRequest request = new _UmweltRequest();
    GetHandler.handle(request);
    assertTrue(request.proccessed);
  }
}
