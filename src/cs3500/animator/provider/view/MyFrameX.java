package cs3500.animator.provider.view;

import java.awt.BorderLayout;
import java.awt.Label;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * More feature frame extends from JFrame.
 */
class MyFrameX extends JFrame {

  private final JButton playButton = new JButton("play");
  private final JButton pauseButton = new JButton("pause");
  private final JButton replayButton = new JButton("replay");
  private final JCheckBox loopCheckBox = new JCheckBox("loop");
  private final JSpinner speedSpinner;

  /**
   * The constructor.
   */
  MyFrameX(int x, int y, JPanel myPanel) {
    setTitle("AnimationInteractiveVisualView");
    setLocation(x, y);
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
    SpinnerModel spinnerModel = new SpinnerNumberModel(20,
        1,
        1000,
        1);
    speedSpinner = new JSpinner(spinnerModel);
    jPanel1.add(speedSpinner);
    jPanel.add(jPanel1);
    add(jPanel, BorderLayout.EAST);
    pack();
  }

  /**
   * get play button.
   *
   * @return the play button.
   */
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
}