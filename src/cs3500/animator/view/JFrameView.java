package cs3500.animator.view;


import cs3500.animator.model.IShape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.event.ChangeListener;

/**
 * Represents the Visual View of an Animation which draws the animation to a panel.
 */
public class JFrameView extends JFrame implements AnimationView {


  protected DrawingPanel drawingPanel;
  protected ArrayList<IShape> shapes;
  protected int y;
  protected int x;
  protected boolean looping;


  /**
   * Constructs a default Visual view for the viewfactory.
   */
  public JFrameView() {
    super("JFrameView");
    this.shapes = new ArrayList<>();
    setSize(1000, 1000);
    setLocation(400, 400);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    drawingPanel = new DrawingPanel(x, y);
    drawingPanel.setShapes(this.shapes);
    add(drawingPanel);
  }

  /**
   * Refreshes the drawing panel.
   */
  public void refresh() {
    drawingPanel.repaint();
  }


  @Override
  public void writeOutUsingBufferedWriter(String output, String outfile) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String xmlModel(double speed) {
    throw new UnsupportedOperationException();
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
    int topX = x;
  }

  @Override
  public void setTopY(int y) {
    int topY = y;
  }

  @Override
  public void setLooping(boolean b) {
    this.looping = b;
  }

  @Override
  public void setLastTick(int t) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setShapes(ArrayList<IShape> shapes) {
    this.shapes = shapes;
    this.drawingPanel.setShapes(this.shapes);
  }

  /**
   * Draws the shapes in this Visual view based on the given time.
   *
   * @param time the time to interpolate by and draw the shapes
   */
  public void drawShapes(int time) {
    for (IShape s : this.shapes) {
      drawingPanel.drawShape(s.convert().interpolate(time));
    }
  }

  @Override
  public void addChange(ChangeListener listener) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void render(double speed, String outfile) {
    Timer timer = new Timer(1000, new ActionListener() {
      int tick = 1;

      /**
       * Starts the time to perform the action needed.
       * @param e the action event to perform
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        drawShapes(tick);
        refresh();
        tick++;
      }
    });
    timer.start();
  }
}
