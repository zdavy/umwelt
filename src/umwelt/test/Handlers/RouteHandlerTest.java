package umwelt.test.Handlers;

import org.junit.Test;

import umwelt.mocks.Routers._UmweltRouter;
import umwelt.server.Handlers.RouteHandler;
import umwelt.mocks.Communication._UmweltRequest;

import static org.junit.Assert.*;

public class RouteHandlerTest {
  @Test public void RouteHandlerProcessesARequest() {
    _UmweltRouter router = new _UmweltRouter();
    RouteHandler handler = new RouteHandler(router);
    _UmweltRequest request = new _UmweltRequest();
    handler.delegate(request);
    assertTrue(router.routed_with(request));
  }
}
