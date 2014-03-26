package umwelt.test.Controllers;
import umwelt.server.Controllers.FileController;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import umwelt.mocks.Communication.Requests._UmweltRequest;

public class FileControllerTest {
  FileController controller;
  _UmweltRequest request;

  @Before public void init() {
    String testDIR = "test";
    controller = new FileController(true, testDIR);
    request = new _UmweltRequest();
  }

  @Test public void TrueIfFileExists(){
    request.stubURI("/test.txt");
    assertTrue(controller.valid(request));
  }

  @Test public void TrueIfRouteExistsPlusHTML() {
    request.stubURI("/test");
    assertTrue(controller.valid(request));
  }

  @Test public void FalseIfRouteDoenstExists() {
    request.stubURI("/doesntExist");
    assertFalse(controller.valid(request));
  }
}
