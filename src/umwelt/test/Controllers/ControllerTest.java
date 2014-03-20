/* src.umwelt.server.Controllers.AbstractController  */
package umwelt.test.Controllers;

import org.junit.Before;
import org.junit.Test;

import umwelt.mocks.Communication.Requests._UmweltRequest;
import umwelt.mocks.Communication.Responses._UmweltResponse;
import umwelt.server.Controllers.AbstractController;

import static org.junit.Assert.*;

public class ControllerTest {
  AbstractController controller;
  _UmweltRequest     request;
  _UmweltResponse    getResponse;
  _UmweltResponse    postResponse;

  @Before public void init() {
    controller   = new AbstractController();
    request      = new _UmweltRequest();
    getResponse  = new _UmweltResponse();
    postResponse = new _UmweltResponse();

    controller.addRoute("get", "/test", getResponse);
    controller.addRoute("post", "/tost", postResponse);
  }

  @Test public void ReturnsTheCorrectResponse() {
    request.stubMethod("get");
    request.stubURI("/test");
    assertEquals(getResponse, controller.handle(request));

    request.stubMethod("post");
    request.stubURI("/tost");
    assertEquals(postResponse, controller.handle(request));
  }

  @Test public void DeterminesIfARequestIsValid() {
    request.stubMethod("delete");
    assertFalse(controller.valid(request));

    request.stubMethod("get");
    request.stubURI("/tost");
    assertFalse(controller.valid(request));

    request.stubURI("/test");
    assertTrue(controller.valid(request));
  }
}
