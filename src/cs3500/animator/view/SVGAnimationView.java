package cs3500.animator.view;

import cs3500.animator.model.IShape;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;

/**
 * Represents an SVG View of this animation which produces an svg Outfile which can then be run in a
 * browser.
 */
public class SVGAnimationView implements AnimationView {

  ArrayList<IShape> shapes;
  int x;
  int y;
  int topX;
  int topY;


  /**
   * Constructs a default SVGview for the viewfactory.
   */
  public SVGAnimationView() {
    this.shapes = new ArrayList<IShape>();
  }

  @Override
  public void setShapes(ArrayList<IShape> model) {
    this.shapes = model;
  }

  @Override
  public void render(double speed, String outfile) throws IOException {
    StringBuilder output = new StringBuilder(
        "<?xml version=" + "\"" + 1.0 + "\"" + " standalone=" + "\"" + "no"
            + "\"" + "?> <!DOCTYPE svg PUBLIC " + "\"" + "-//W3C//DTD SVG 1.1//EN" + "\"" + " "
            + "\""
            + "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd" + "\"" + ">");
    output.append(this.xmlModel(speed));
    this.writeOutUsingBufferedWriter(output.toString(), outfile);
  }

  @Override
  public void refresh() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void drawShapes(int time) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String xmlModel(double speed) {
    String result = "<svg width=" + "\"" + this.x + "\""
        + " height=" + "\"" + this.y + "\""
        + " viewBox=" + "\"" + this.topX + " " + this.topY + " " + this
        .x + " " + this.y + "\""
        + " xmlns=" + "\"" + "http://www.w3.org/2000/svg" + "\""
        + " version=" + "\"" + 1.1 + "\"" + ">"
        + "<desc>Example anim01 - demonstrate animation elements</desc>";
    for (IShape s : this.shapes) {
      result += (new XMLShape(s).xmlShape(speed) + "\n");
    }
    return result + "</svg>";
  }

  @Override
  public void setPaused(Boolean b) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean getPaused() {
    throw new UnsupportedOperationException();
  }

  @Override
  public JButton getPlay() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addListener(ActionListener listener) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void addChange(ChangeListener listener) {
    throw new UnsupportedOperationException();
  }


  @Override
  public void setTickSpeed(double value) {
    throw new UnsupportedOperationException();
  }


  @Override
  public void reDo() {
    throw new UnsupportedOperationException();
  }


  @Override
  public int getTick() {
    throw new UnsupportedOperationException();
  }


  @Override
  public void setX(int x) {
    this.x = x;
  }

  @Override
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public void setTopX(int x) {
    this.topX = x;
  }

  @Override
  public void setTopY(int y) {
    this.topY = y;
  }

  @Override
  public void setLooping(boolean b) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setLastTick(int t) {
    throw new UnsupportedOperationException();
  }

  @Override
  public JButton getLooping() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void writeOutUsingBufferedWriter(String output, String outfile) throws IOException {
    if (outfile.compareTo("System.out") == 0 || outfile.compareTo("out") == 0) {
      new PrintStream("outfile").printf(output);
    } else {
      new PrintStream(outfile).printf(output);
    }
  }

}
