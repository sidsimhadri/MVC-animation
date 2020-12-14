package cs3500.animator.view;


import cs3500.animator.model.IShape;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;

/**
 * Represents a Textual View of the Animation.
 */
public class TextualView implements AnimationView {

  ArrayList<IShape> shapes;
  private int x;
  private int y;
  private int topX;
  private int topY;

  /**
   * Constructs a TextualView.
   */
  public TextualView() {
    this.shapes = new ArrayList<IShape>();
  }


  @Override
  public void setShapes(ArrayList<IShape> model) {
    this.shapes = model;
  }

  @Override
  public void render(double speed, String outfile) throws IOException {
    String result = "canvas " + this.topX + " " + this.topY + " " + this.x + " " + this.y + "\n";
    for (IShape s : this.shapes) {
      result += new TextualShape(s).render(speed);
    }
    this.writeOutUsingBufferedWriter(result, outfile);
  }

  @Override
  public void addChange(ChangeListener listener) {
    throw new UnsupportedOperationException();
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
  public void writeOutUsingBufferedWriter(String output, String outfile) throws IOException {
    if (outfile.compareTo("System.out") == 0 || outfile.compareTo("out") == 0) {
      System.out.print(output);
    } else {
      new PrintStream(outfile).printf(output);
    }
  }

  @Override
  public String xmlModel(double speed) {
    return null;
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
  public void setTickSpeed(double value) {
    throw new UnsupportedOperationException();
  }


  @Override
  public JButton getLooping() {
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

}


