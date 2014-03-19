/* src.umwelt.server.Routers.UmweltRouter */
package umwelt.test.Routers;

import org.junit.Test;

import umwelt.mocks.Communication.*;
import umwelt.server.Routers.*;
import umwelt.server.Communication.FOFResponse;
import umwelt.server.Communication.iResponse;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UmweltRouterTest {
  @Test public void Get404IfRouteDoesntExistGetResponseIfItDoes() {
    iRouter router = new UmweltRouter();
    _GetRequest request = new _GetRequest();
    assertThat(router.route(request), instanceOf(FOFResponse.class));

    router.addRoute("get", "/test", new _UmweltResponse());
    assertThat(router.route(request), instanceOf(iResponse.class));
  }

  /* @Test public void PostDelegegateToPostHandlerReturnsUmweltResponseIfExists() { */
  /*   iRouter router = new UmweltRouter(); */
  /*   _PostRequest request = new _PostRequest(); */
  /*   assertThat(router.route(request), instanceOf(FOFResponse.class)); */
  /*  */
  /*   router.addRoute("post", "/test", new _UmweltResponse()); */
  /*   assertThat(router.route(request), instanceOf(iResponse.class)); */
  /* } */
}
