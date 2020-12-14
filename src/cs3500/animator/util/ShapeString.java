package cs3500.animator.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

class ShapeString {

  public String str;

  public ShapeString(String str) {
    this.str = str;
  }

  String toTop() throws IOException {
    BufferedReader bufReader = new BufferedReader(new StringReader(str));
    String line = null;
    StringBuilder shapes = new StringBuilder();
    StringBuilder motions = new StringBuilder();
    while ((line = bufReader.readLine()) != null) {
      if (line.contains("shape") || line.contains("canvas")) {
        shapes.append(line + "\n");
      } else {
        motions.append(line + "\n");
      }
    }
    this.str = shapes.toString() + motions.toString();
    return str;
  }
}
