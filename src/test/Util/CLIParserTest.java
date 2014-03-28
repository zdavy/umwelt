package test.Util;

import org.junit.Test;

import test.Helpers.FileHelper;

import umwelt.Util.CLIParser;

import static org.junit.Assert.*;

public class CLIParserTest {

  @Test public void properlyParsesPortIfValid() {
    String string = "-t fakedata -p 3000 -d directory";
    String[] input = string.split("\\s+");
    assertEquals(3000, CLIParser.getPort(input));
  }

  @Test public void returns5000whenPortIsInvalid() {
    String string = "-r fakedata -d directory";
    String[] input = string.split("\\s+");
    assertEquals(5000, CLIParser.getPort(input));
  }

  @Test public void properlyParsesDirectory() throws Exception {
    FileHelper.createDirectory("directory");
    String string = "-t fakedata -p 3000 -d directory";
    String[] input = string.split("\\s+");
    assertEquals("directory", CLIParser.getDIR(input));
    FileHelper.destroyFile("directory");
  }

  @Test public void returnsRootIfDirectoryDoesntExists() throws Exception {
    String string = "-t fakedata -p 3000 -d directory";
    String[] input = string.split("\\s+");
    assertEquals(System.getProperty("user.dir"), CLIParser.getDIR(input));
  }
}
