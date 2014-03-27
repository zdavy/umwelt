package dasMocks.Util;

import java.io.InputStream;

import dasMocks.Requests._Request;
import dasBoot.Utils.iParser;

public class _Parser implements iParser {
  public _Request request(InputStream input) {
    return new _Request("test", "/test");
  }
}
