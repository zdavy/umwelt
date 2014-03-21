package umwelt.test.Controllers;

import org.junit.Test;
import static org.junit.Assert.*;

import umwelt.mocks.Communication.Requests._UmweltRequest;
import umwelt.server.Controllers.FileController;

public class FileControllerTest {
  @Test public void TrueIfFileExistsFalseIfNot(){
    String testDIR = "/test";
    FileController controller = new FileController(testDIR);
    _UmweltRequest request = new _UmweltRequest();

    assertFalse(controller.valid(request));

    request.stubURI("/test.txt");
    assertTrue(controller.valid(request));
  }
}
