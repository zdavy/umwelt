/* src.umwelt.server.Routers.UmweltRouter */
package umwelt.test.Routers;

import umwelt.server.Routers.UmweltRouter;
import umwelt.mocks.Controllers._Controller;
import umwelt.server.Communication.Responses.FOFResponse;
import umwelt.mocks.Communication.Requests._UmweltRequest;
import umwelt.mocks.Communication.Responses._UmweltResponse;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UmweltRouterTest {
  UmweltRouter router;
  _UmweltResponse response;
  _Controller testController;
  _UmweltRequest request;

  @Before public void init() {
    request        = new _UmweltRequest();
    testController = new _Controller("test");
    response       = new _UmweltResponse();
    testController.stubRoute("get/test", response);
  }

  @Test public void returns404IfNoRoute(){
    router = new UmweltRouter(testController);
    assertThat(router.route(request), instanceOf(FOFResponse.class));
    assertThat(router.route(request), not(instanceOf(_UmweltResponse.class)));
  }

  @Test public void HasCorrectControllerDealWithRequest(){
    router = new UmweltRouter(testController);
    testController.stubValid(true);
    assertThat(router.route(request), instanceOf(_UmweltResponse.class));
    assertThat(router.route(request), not(instanceOf(FOFResponse.class)));
  }
}
