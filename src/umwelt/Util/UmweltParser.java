package umwelt.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import umwelt.Requests.UmweltRequest;

import dasBoot.Utils.iParser;

public class UmweltParser implements iParser {
  UmweltRequest request;
  BufferedReader input;

  public UmweltRequest request(InputStream input) {
    request = new UmweltRequest();
    this.input = read(input);
    assignRequestLine(nextLine().split("\\s"));
    assignHeader(nextLine());
    assignBody(new char[request.contentLength()]);
    return request;
  }

  private BufferedReader read(InputStream input) {
    return new BufferedReader(new InputStreamReader(input));
  }

  private String nextLine() {
    try {
      String value = input.readLine();
      return value;
    } catch (IOException e) {
      return null;
    }
  }

  private String nextLine(char[] content) {
    try {
      input.read(content, 0, request.contentLength());
      String value = new String(content);
      return value;
    } catch (IOException e) {
      return null;
    }
  }

  private void assignRequestLine(String[] line) {
    request.setMethod(line[0]);
    setURI(line[1]);
    request.setVersion(line[2]);
  }

  public void setURI(String uri){
    try {
      String[] extraction = uri.split("\\?");
      request.setURI(extraction[0]);
      splitParameters(extraction[1]);
    } catch (ArrayIndexOutOfBoundsException e) {
      request.setURI(uri);
    }
  }

  private void splitParameters(String content) {
      for(String param: content.split("&")) {
        request.setBody(param.split("="));
      }
  }

  private void assignHeader(String line) {
    if(validHeader(line)) {
      request.addHeader(line.split(": "));
      assignHeader(nextLine());
    }
  }

  private void assignBody(char[] content) {
    if(hasContent(content)) {
      String body = nextLine(content);
      addParameters(String.valueOf(body));
    }
  }

  private void addParameters(String content) {
    String decoded;
    try { decoded = java.net.URLDecoder.decode(content, "UTF-8");}
    catch (Exception e) { decoded = content; }
    for(String param: decoded.split("&")) {
        request.setBody(param.split("="));
    }
  }

  private boolean hasContent(char[] content) {
    return content.length > 0;
  }

  private boolean validHeader(String header) {
    return (!(header == null) && (!header.equals("")));
  }
}
