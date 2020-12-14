package cs3500.animator;

import cs3500.animator.provider.view.AnimationInteractiveView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * My implementation of the provider's controller.
 */
public class ProviderController implements IProviderController, ChangeListener, ActionListener {

  AnimationInteractiveView view;


  public ProviderController(AnimationInteractiveView view) {
    this.view = view;
  }


  /**
   * Invoked when an action occurs.
   *
   * @param e the event to be processed
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "play":
        this.play();
        break;
      case "pause":
        this.pause();
        break;
      case "replay":
        this.replay();
        break;
      case "loop":
        JCheckBox check = (JCheckBox) e.getSource();
        if (check.isSelected()) {
          this.enableLoop();
        } else {
          this.disableLoop();
        }
        break;
      default:
        throw new IllegalArgumentException("Unexpected Input");
    }
  }

  /**
   * Invoked when the target of the listener has changed its state.
   *
   * @param e a ChangeEvent object
   */
  @Override
  public void stateChanged(ChangeEvent e) {

    JSpinner spinner = (JSpinner) e.getSource();
    this.view.setSpeed((int) spinner.getValue());
  }

  /**
   * Runs the view.
   */
  @Override
  public void start() throws IOException {
    this.view.addListener(this, this);
    this.view.render();
    this.view.play();
  }

  /**
   * play a animation from current position.
   */
  @Override
  public void play() {
    this.view.play();
  }

  /**
   * pause animation.
   */
  @Override
  public void pause() {
    this.view.pause();
  }

  /**
   * replay the animation from begin.
   */
  @Override
  public void replay() {
    this.view.replay();
  }

  /**
   * enable the loop play feature.
   */
  @Override
  public void enableLoop() {
    this.view.enableLoop();
  }

  /**
   * disable the loop play feature.
   */
  @Override
  public void disableLoop() {
    this.view.disableLoop();
  }

}
