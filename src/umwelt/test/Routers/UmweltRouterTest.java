package umwelt.test.Routers;
import umwelt.server.Routers.UmweltRouter;

import umwelt.mocks.Controllers._Controller;
import umwelt.mocks.Requests._UmweltRequest;
import umwelt.mocks.Responses._UmweltFactory;
import umwelt.mocks.Responses._UmweltResponse;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class UmweltRouterTest {
  _Controller testController;
  _Controller[] controllers;
  _UmweltRequest request;
  _UmweltFactory responder;
  UmweltRouter router;

  @Before public void init() {
    _UmweltResponse response = new _UmweltResponse();
    testController = new _Controller("test");
    controllers = new _Controller[1];
    controllers[0] = testController;
    request = new _UmweltRequest();
    testController.stubRoute("get/test", response);
  }

  @Test public void returns404IfNoRoute() throws Exception {
    router = new UmweltRouter(controllers, responder);
    assertThat(router.route(request), not(instanceOf(_UmweltResponse.class)));
  }

  @Test public void HasCorrectControllerDealWithRequest() throws Exception {
    router = new UmweltRouter(controllers, responder);
    testController.stubValid(true);
    assertThat(router.route(request), instanceOf(_UmweltResponse.class));
  }
}
