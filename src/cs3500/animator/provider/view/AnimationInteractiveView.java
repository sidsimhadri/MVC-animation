package cs3500.animator.provider.view;

import java.awt.event.ActionListener;
import javax.swing.event.ChangeListener;

/**
 * Interface for Interactive Animation View.
 */
public interface AnimationInteractiveView extends ProviderAnimationView {

  /**
   * play a animation from current position.
   */
  void play();


  /**
   * pause animation.
   */
  void pause();

  /**
   * replay the animation from begin.
   */
  void replay();

  /**
   * enable the loop play feature.
   */
  void enableLoop();

  /**
   * disable the loop play feature.
   */
  void disableLoop();


  /**
   * set speed value.
   *
   * @param speed speed
   */
  void setSpeed(double speed);

  /**
   * Adds the given listeners to the relevant buttons.
   * @param eventListener the ActionListener to add
   * @param listener the ChangeListener to add
   */
  void addListener(ActionListener eventListener, ChangeListener listener);


}
