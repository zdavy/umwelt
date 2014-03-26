package umwelt.test.Controllers;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import umwelt.mocks.Requests._UmweltRequest;
import umwelt.mocks.Responses._UmweltResponse;
import umwelt.server.Controllers.UmweltController;
import umwelt.server.Responses.iResponse;

import static org.junit.Assert.*;

public class UmweltControllerTest {
  UmweltController controller;
  _UmweltRequest     request;
  _UmweltResponse    getResponse;
  _UmweltResponse    postResponse;

  @Before public void init() {
    controller   = new UmweltController();
    request      = new _UmweltRequest();
    getResponse  = new _UmweltResponse();
    postResponse = new _UmweltResponse();

    controller.addRoute("get", "/get", getResponse);
    controller.addRoute("post", "/post", postResponse);
  }

  @Test public void ReturnsTheCorrectResponse() throws IOException {
    iResponse response;

    request.stubMethod("get");
    request.stubURI("/get");
    response = controller.handle(request);
    assertEquals(getResponse, response);

    request.stubMethod("post");
    request.stubURI("/post");
    response = controller.handle(request);
    assertEquals(postResponse, response);

    request.stubURI("/get");
    request.stubMethod("post");
    response = controller.handle(request);
    assertEquals("405", response.getResponseLine().get("code"));
  }

  @Test public void DeterminesIfARouteIsValid() {
    request.stubURI("/test");
    assertFalse(controller.valid(request));

    request.stubURI("/get");
    assertTrue(controller.valid(request));
  }

  @Test public void DeterminesIfMethodIsValidAndReturnsResponse() {
    request.stubURI("/get");
    request.stubURI("/");
    assertFalse(controller.valid(request));

    request.stubURI("/get");
    assertTrue(controller.valid(request));
  }

  @Test public void AddsAllRouteTypes() throws IOException {
    controller = new UmweltController();
    iResponse response = new _UmweltResponse();

    request.stubURI("/get");
    request.stubMethod("get");
    assertFalse(controller.valid(request));
    controller.get("/get", response);
    assertEquals(controller.handle(request), response);

    request.stubURI("/post");
    request.stubMethod("post");
    assertFalse(controller.valid(request));
    controller.post("/post", response);
    assertEquals(controller.handle(request), response);

    request.stubURI("/put");
    request.stubMethod("put");
    assertFalse(controller.valid(request));
    controller.put("/put", response);
    assertEquals(controller.handle(request), response);

    request.stubURI("/patch");
    request.stubMethod("patch");
    assertFalse(controller.valid(request));
    controller.patch("/patch", response);
    assertEquals(controller.handle(request), response);

    request.stubURI("/delete");
    request.stubMethod("delete");
    assertFalse(controller.valid(request));
    controller.delete("/delete", response);
    assertEquals(controller.handle(request), response);
  }
}
