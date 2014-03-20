/* src.umwelt.server.Handlers.GetHandler */
package umwelt.test.Controllers;

import org.junit.Test;

import umwelt.mocks.Communication.Requests._UmweltRequest;
import umwelt.mocks.Communication.Responses._UmweltResponse;
import umwelt.server.Controllers.GetController;

import static org.junit.Assert.*;

public class GetControllerTest {
  @Test public void responseIsProccessedWithRequestData() {
    GetController controller = new GetController();
    controller.addRoute("/test", new _UmweltResponse());
    _UmweltRequest request = new _UmweltRequest();
    controller.handle(request);
    assertTrue(request.proccessed);
  }
}
