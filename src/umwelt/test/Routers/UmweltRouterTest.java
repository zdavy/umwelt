/* src.umwelt.server.Routers.UmweltRouter */
package umwelt.test.Routers;

import org.junit.Test;

import umwelt.mocks.Communication.*;
import umwelt.server.Routers.*;
import umwelt.server.Communication.FOFResponse;
import umwelt.server.Communication.UmweltResponse;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class UmweltRouterTest {
  @Test public void GetMethodsDelegegateToGetHandlerReturnsUmweltResponse() {
    iRouter router = new UmweltRouter();
    _GetRequest request = new _GetRequest();
    assertThat(router.route(request), instanceOf(UmweltResponse.class));
  }

  @Test public void PostMethodsDelegegateToPostHandlerReturnsUmweltResponse() {
    iRouter router = new UmweltRouter();
    _PostRequest request = new _PostRequest();
    assertThat(router.route(request), instanceOf(UmweltResponse.class));
  }

  @Test public void FOFMethodsDelegegateToFOFHandlerReturnsFOFResponse() {
    iRouter router = new UmweltRouter();
    _FOFRequest request = new _FOFRequest();
    assertThat(router.route(request), instanceOf(FOFResponse.class));
  }
}
