package cs3500.animator.view;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeListener;

/**
 * Represents the Visual View of an Animation which draws the animation to a panel.
 */
public class JFrameInteractiveView extends JFrameView implements AnimationView {


  private final JButton play;
  private final JButton restart;
  private final JButton loop;
  private final JSlider zoom;
  private boolean isPaused = false;

  private boolean redo = false;
  private double tickSpeed;
  double tick = 1;
  private int lastTick;

  /**
   * Constructs a default Visual view for the viewfactory.
   */
  public JFrameInteractiveView() {

    super();
    this.tickSpeed = 1;
    this.shapes = new ArrayList<>();
    setPreferredSize(new Dimension(700, 500));
    setVisible(true);
    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel rightPanel = new JPanel();
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
    this.drawingPanel = new DrawingPanel(x, y);
    play = new JButton("Pause");
    restart = new JButton("Restart");
    loop = new JButton("Loop");

    Hashtable<Integer, JLabel> table = new Hashtable<>();
    table.put(0, new JLabel("Slow"));
    table.put(50, new JLabel("Slowish"));
    table.put(100, new JLabel("Regular"));
    table.put(150, new JLabel("Fastish"));
    table.put(200, new JLabel("Fast"));

    zoom = new JSlider(0, 200, 100);
    zoom.setMajorTickSpacing(50);
    zoom.setMinorTickSpacing(25);

    zoom.setLabelTable(table);
    play.setActionCommand("play");
    loop.setActionCommand("loop");
    restart.setActionCommand("restart");
    zoom.setPaintTicks(true);
    zoom.setPaintLabels(true);
    zoom.setSnapToTicks(true);
    drawingPanel.setShapes(this.shapes);
    add(drawingPanel, BorderLayout.CENTER);
    add(rightPanel, BorderLayout.EAST);
    rightPanel.add(play);
    rightPanel.add(restart);
    rightPanel.add(loop);
    add(zoom, BorderLayout.SOUTH);
    pack();
  }

  @Override
  public void setPaused(Boolean b) {
    this.isPaused = b;
  }

  @Override
  public boolean getPaused() {
    return isPaused;
  }

  @Override
  public JButton getPlay() {
    return this.play;
  }

  public void reDo() {
    this.redo = true;
  }


  @Override
  public int getTick() {
    return (int) tick;
  }


  @Override
  public void setLastTick(int t) {
    this.lastTick = t;
  }


  @Override
  public void addListener(ActionListener listener) {
    Objects.requireNonNull(listener);
    play.addActionListener(listener);
    restart.addActionListener(listener);
    loop.addActionListener(listener);

  }

  @Override
  public void addChange(ChangeListener listener) {
    Objects.requireNonNull(listener);
    zoom.addChangeListener(listener);
  }


  @Override
  public void setTickSpeed(double value) {
    this.tickSpeed = value;
  }


  @Override
  public JButton getLooping() {
    return loop;
  }


  @Override
  public void render(double speed, String outfile) {

    Timer timer = new Timer(1000, new ActionListener() {


      /**
       * Starts the time to perform the action needed.
       * @param e the action event to perform
       */
      @Override
      public void actionPerformed(ActionEvent e) {

        if (redo) {
          tick = 1;
          tickSpeed = 1;
          zoom.setValue(100);
          looping = false;
          loop.setText("loop");
          drawShapes((int) tick);
          refresh();
          redo = false;
        }
        if (!isPaused) {
          drawShapes((int) tick);
          refresh();
          tick += tickSpeed;
        }
        if (looping && (tick > lastTick)) {
          tick = 1;
          drawShapes((int) tick);
          refresh();
        }
      }
    });
    timer.start();
  }
}
