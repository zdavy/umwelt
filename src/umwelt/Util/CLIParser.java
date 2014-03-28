package umwelt.Util;

import java.io.File;
import java.util.Arrays;

public class CLIParser {
  public static int getPort(String[] args) {
    try {
      String port = args[Arrays.asList(args).indexOf("-p") + 1];
      return Integer.valueOf(port);
    } catch (Exception e) {
      return 5000;
    }
  }

  public static String getDIR(String[] args) {
    String dir = args[Arrays.asList(args).indexOf("-d") + 1];
    return (new File(dir).isDirectory()) ? dir : System.getProperty("user.dir");
  }
}
