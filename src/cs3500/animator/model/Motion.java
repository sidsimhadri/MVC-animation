package cs3500.animator.model;

import cs3500.animator.provider.model.ProviderMotion;
import cs3500.animator.provider.model.ProviderMotionImpl;

/**
 * Represents a motion that will occur in the animation.
 */
public class Motion implements IMotion {

  private int start;
  private int end;
  private IShape initial;
  private IShape result;

  /**
   * Constructs a motion to be animated.
   *
   * @param start   the start time of the motion
   * @param end     the end time of the motion
   * @param initial the shape at the beginning of the motion
   * @param result  the shape at the end of the motion
   */
  public Motion(int start, int end, IShape initial, IShape result) {
    this.start = start;
    this.end = end;
    this.initial = initial;
    this.result = result;
  }


  @Override
  public String toString() {
    return "motion " + this.initial.getName() + " " + start + " " + this.initial
        .getPos().toString() + " " + this.initial.getDim().toString() + " " + this.initial
        .getColor()
        .toString() + " " + end + " " + this.result.getPos().toString()
        + " " + this.result.getDim().toString() + " " + this.result.getColor()
        .toString();
  }

  /**
   * Gets the start time of this motion.
   *
   * @return the time to start
   */
  public int getStart() {
    return this.start;
  }

  /**
   * Gets the end time of this motion.
   *
   * @return the time to end
   */
  public int getEnd() {
    return this.end;
  }

  /**
   * Gets the initial shape of the motion.
   *
   * @return the initial shape of the motion
   */
  public IShape getInitial() {
    return this.initial;
  }

  /**
   * Gets the resulting shape of the motion.
   *
   * @return the resulting shape of the motion
   */
  public IShape getResult() {
    return this.result;
  }

  @Override
  public ProviderMotion convert() {
    return new ProviderMotionImpl(this.start, this.end, initial.customer(), result.customer());
  }
}
