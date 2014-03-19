/* src.umwelt.server.Routers.UmweltRouter */
package umwelt.test.Routers;

import org.junit.Before;
import org.junit.Test;

import umwelt.mocks.Communication.*;
import umwelt.mocks.Handlers._GetHandler;
import umwelt.mocks.Handlers._PostHandler;
import umwelt.server.Routers.*;
import umwelt.server.Communication.FOFResponse;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UmweltRouterTest {
  _GetHandler  getHandler  = new _GetHandler();
  _PostHandler postHandler = new _PostHandler();
  iRouter router = new UmweltRouter(getHandler, postHandler);

  @Before public void init() {
    router.addRoute("MockGet", "/test", new _UmweltResponse());
    router.addRoute("MockPost", "/test", new _UmweltResponse());
  }

  @Test public void Get404IfRouteDoesntExistGetResponseIfItDoes() {
    _GetRequest request = new _GetRequest();

    assertThat(router.route(request), instanceOf(FOFResponse.class));
    getHandler.stubValid(true);
    assertThat(router.route(request), not(instanceOf(FOFResponse.class)));
  }

  @Test public void Get404IfRouteDoesntExistPostResponseIfItDoes() {
    _PostRequest request = new _PostRequest();

    assertThat(router.route(request), instanceOf(FOFResponse.class));
    postHandler.stubValid(true);
    assertThat(router.route(request), not(instanceOf(FOFResponse.class)));
  }
}
