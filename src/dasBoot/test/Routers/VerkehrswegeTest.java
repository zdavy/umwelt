package dasBoot.test.Routers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import dasBoot.mocks.Controllers._Controller;
import dasBoot.mocks.Requests._Request;
import dasBoot.mocks.Responses._Factory;
import dasBoot.server.Routers.Verkehrswege;
import dasBoot.test.Helpers.FileHelper;

public class VerkehrswegeTest {
  Verkehrswege router;
  _Request request;
  _Factory factory;

  @Before public void init() {
    request = new _Request("test", "/test.txt");
    factory = new _Factory();
    _Controller[] controllers = new _Controller[1];
    _Controller controller = new _Controller(factory);
    controllers[0] = controller;
    router = new Verkehrswege(controllers, factory);
  }

  @Test public void FileNotFoundIfControllerIsNullOrInvalid() throws Exception {
    router.route(request);
    assertTrue(factory.fileWasNotFound);
  }

  @Test public void ControllerHandlesRequestIfValidRequest() throws Exception {
    FileHelper.createFile("test.txt");
    router.route(request);
    assertFalse(factory.fileWasNotFound);
    FileHelper.destroyFile("test.txt");
  }
}
