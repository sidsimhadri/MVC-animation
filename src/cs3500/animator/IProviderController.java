package cs3500.animator;

import java.io.IOException;

/**
 * Used to start AnimationInteractiveView and perform different operations on View.
 */
public interface IProviderController {

  /**
   * Runs the view.
   */
  void start() throws IOException;

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
}
