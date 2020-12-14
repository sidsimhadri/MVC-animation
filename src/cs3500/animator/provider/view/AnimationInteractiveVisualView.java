package cs3500.animator.provider.view;

import cs3500.animator.provider.model.AbstractAnimation;
import cs3500.animator.provider.model.ProviderMotion;
import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

/**
 * a implementation for AnimationInteractiveView. Used GUI framework is Java swing.
 */
public class AnimationInteractiveVisualView implements AnimationInteractiveView {

  private double speed;
  private AbstractAnimation<ProviderMotion> animation;
  private int cur;
  private final MyFrameX myFrame;
  private final MyPanel myPanel;
  private Thread thread;
  private boolean loop;
  private final JButton playButton = new JButton("play");
  private final JButton pauseButton = new JButton("pause");
  private final JButton replayButton = new JButton("replay");
  private final JCheckBox loopCheckBox = new JCheckBox("loop");
  private final JSpinner speedSpinner;

  /**
   * The constructor.
   *
   * @param speed     speed.
   * @param animation animation model.
   */
  public AnimationInteractiveVisualView(double speed, AbstractAnimation<ProviderMotion> animation) {
    if (speed <= 0 || animation == null) {
      throw new IllegalArgumentException();
    }
    this.speed = speed;
    this.animation = animation;
    myPanel = new MyPanel(animation);
    SpinnerModel spinnerModel = new SpinnerNumberModel(20,
        1,
        1000,
        1);
    speedSpinner = new JSpinner(spinnerModel);
    myFrame = new MyFrameX();
    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void render() {
    myFrame.setVisible(true);
  }


  /**
   * More feature frame extends from JFrame.
   */
  class MyFrameX extends JFrame {

    /**
     * The constructor.
     */
    MyFrameX() {
      setTitle("AnimationInteractiveVisualView");
      setLocation(animation.getCanvas().getX(), animation.getCanvas().getY());
      setLayout(new BorderLayout());
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setViewportView(myPanel);
      add(scrollPane, BorderLayout.CENTER);
      JPanel jPanel = new JPanel();
      jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
      jPanel.add(playButton);
      jPanel.add(pauseButton);
      jPanel.add(replayButton);
      jPanel.add(loopCheckBox);
      JPanel jPanel1 = new JPanel();
      jPanel1.add(new Label("speed:"));
      jPanel1.add(speedSpinner);
      jPanel.add(jPanel1);
      add(jPanel, BorderLayout.EAST);
      pack();
    }
  }

  @Override
  public void play() {
    if (thread != null && thread.isAlive()) {
      return;
    }
    if (cur == animation.getLength()) {
      cur = 0;
    }
    myPanel.setTick(cur);
    thread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (cur < animation.getLength()) {
          try {
            synchronized (this) {
              Thread.sleep((int) (1000 / speed));
            }
          } catch (InterruptedException e) {
            return;
          }
          myFrame.repaint();
          cur++;
          synchronized (this) {
            if (loop && cur == animation.getLength()) {
              cur = 0;
              myPanel.setTick(0);
            }
          }
        }
      }
    });
    thread.start();
  }

  @Override
  public void pause() {
    if (thread != null && thread.isAlive()) {
      thread.interrupt();
    }
    thread = null;
  }

  @Override
  public void replay() {
    cur = 0;
    pause();
    play();
  }

  @Override
  public synchronized void enableLoop() {
    loop = true;
  }

  @Override
  public synchronized void disableLoop() {
    loop = false;
  }

  @Override
  public synchronized void setSpeed(double speed) {
    this.speed = speed;
  }

  public void setAnimation(AbstractAnimation<ProviderMotion> animation) {
    this.animation = animation;
  }

  @Override
  public void addListener(ActionListener eventListener, ChangeListener listener) {
    Objects.requireNonNull(eventListener);
    Objects.requireNonNull(listener);
    playButton.addActionListener(eventListener);
    pauseButton.addActionListener(eventListener);
    replayButton.addActionListener(eventListener);
    loopCheckBox.addActionListener(eventListener);
    speedSpinner.addChangeListener(listener);
  }


  public JButton getPlayButton() {
    return playButton;
  }

  /**
   * get pause button.
   *
   * @return the pause button.
   */
  public JButton getPauseButton() {
    return pauseButton;
  }

  /**
   * get replay button.
   *
   * @return the replay button.
   */
  public JButton getReplayButton() {
    return replayButton;
  }

  /**
   * get loop checkbox.
   *
   * @return the loop checkbox.
   */
  public JCheckBox getLoopCheckBox() {
    return loopCheckBox;
  }

  /**
   * get speed spinner.
   *
   * @return the speed spinner.
   */
  public JSpinner getSpeedSpinner() {
    return speedSpinner;
  }

  /**
   * get current speed.
   *
   * @return the current speed
   */
  public double getSpeed() {
    return speed;
  }

  /**
   * get current position of playing.
   *
   * @return the replay button.
   */
  public int getCur() {
    return cur;
  }

  /**
   * get loop status.
   *
   * @return the loop status.
   */
  public boolean isLoop() {
    return loop;
  }
}
