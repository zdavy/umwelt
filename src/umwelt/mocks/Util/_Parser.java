package umwelt.mocks.Util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import umwelt.mocks.Requests._Request;
import umwelt.server.Utils.iParser;

public class _Parser implements iParser {
  public _Request request(InputStream input) {
    return new _Request(new ByteArrayInputStream(new byte[1]));
  }
}
