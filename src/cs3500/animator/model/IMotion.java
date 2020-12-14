package cs3500.animator.model;

import cs3500.animator.provider.model.ProviderMotion;

/**
 * Represents a motion from one shape to another.
 */
public interface IMotion {


  /**
   * Gets the start time of this motion.
   *
   * @return the time to start
   */
  int getStart();

  /**
   * Gets the end time of this motion.
   *
   * @return the time to end
   */
  int getEnd();

  /**
   * Gets the initial shape of the motion.
   *
   * @return the initial shape of the motion
   */
  IShape getInitial();

  /**
   * Gets the resulting shape of the motion.
   *
   * @return the resulting shape of the motion
   */
  IShape getResult();

  /**
   * Converts this motion to a CustomerMotion.
   *
   * @return the converted CustomerMotion
   */
  ProviderMotion convert();
}
