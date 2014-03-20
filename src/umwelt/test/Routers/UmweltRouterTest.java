/* src.umwelt.server.Routers.UmweltRouter */
package umwelt.test.Routers;

import org.junit.Before;
import org.junit.Test;

import umwelt.mocks.Communication._GetRequest;
import umwelt.mocks.Communication._PostRequest;
import umwelt.mocks.Communication.Responses._UmweltResponse;
import umwelt.mocks.Controllers._GetController;
import umwelt.mocks.Controllers._PostController;
import umwelt.server.Communication.Responses.iResponse;
import umwelt.server.Routers.UmweltRouter;
import umwelt.server.Routers.iRouter;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UmweltRouterTest {
  _GetController  getController  = new _GetController();
  _PostController postController = new _PostController();
  iRouter controller = new UmweltRouter(getController, postController);

  @Before public void init() {
    controller.addRoute("MockGet", "/test", new _UmweltResponse());
    controller.addRoute("MockPost", "/test", new _UmweltResponse());
  }

  @Test public void Get404IfRouteDoesntExistGetResponseIfItDoes() {
    _GetRequest request = new _GetRequest();

    assertThat(controller.route(request), instanceOf(iResponse.class));
    getController.stubValid(true);
    assertThat(controller.route(request), not(instanceOf(iResponse.class)));
  }

  @Test public void Get404IfRouteDoesntExistPostResponseIfItDoes() {
    _PostRequest request = new _PostRequest();

    assertThat(controller.route(request), instanceOf(iResponse.class));
    postController.stubValid(true);
    assertThat(controller.route(request), not(instanceOf(iResponse.class)));
  }
}
