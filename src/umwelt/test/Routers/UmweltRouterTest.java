/* src.umwelt.server.Routers.UmweltRouter */
package umwelt.test.Routers;

import org.junit.Test;

import umwelt.mocks.Communication.*;
import umwelt.server.Routers.*;
import umwelt.server.Communication.FOFResponse;
import umwelt.server.Communication.GetResponse;
import umwelt.server.Communication.PostResponse;
import umwelt.server.Communication.iResponse;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

public class UmweltRouterTest {
  @Test public void GetMethodsDelegegateToGetHandlerReturnsGetResponse() {
    iRouter router = new UmweltRouter();
    _GetRequest request = new _GetRequest();
    iResponse response = router.route(request);
    assertThat(response, instanceOf(GetResponse.class));
  }

  @Test public void PostMethodsDelegegateToPostHandlerReturnsPostResponse() {
    iRouter router = new UmweltRouter();
    _PostRequest request = new _PostRequest();
    iResponse response = router.route(request);
    assertThat(response, instanceOf(PostResponse.class));
  }

  @Test public void FOFMethodsDelegegateToFOFHandlerReturnsFOFResponse() {
    iRouter router = new UmweltRouter();
    _FOFRequest request = new _FOFRequest();
    iResponse response = router.route(request);
    assertThat(response, instanceOf(FOFResponse.class));
  }
}
