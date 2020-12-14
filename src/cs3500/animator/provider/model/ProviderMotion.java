package cs3500.animator.provider.model;


import cs3500.animator.model.Color;
import cs3500.animator.model.Posn;

/**
 * represent a shape's transition with a timeline, which is inclusive at the start point but
 * exclusive at the endpoint. The startShape is the start state of the motion and endshape is the
 * end state of the motion. Contains the start time/shape and end time/shape, @throws
 * IllegalArgumentException if the given shapes is null of the time is invalid
 */
public interface ProviderMotion extends Comparable<ProviderMotion> {

  /**
   * determine whether the given motion is adjacent next to this motion.
   *
   * @param other given motion
   * @return true if the other motion if right after this motion
   */
  public boolean adjNext(ProviderMotion other);

  /**
   * determine whether the given motion is come right before to this motion.
   *
   * @param other given motion
   * @return true if the other motion is right before this motion
   */
  public boolean adjPrior(ProviderMotion other);

  /**
   * make a copy of this motion.
   *
   * @return Motion as the copy
   */
  public ProviderMotion clone();

  /**
   * compute the length of the timeline of this motion.
   *
   * @return int as the length of timeline
   */
  public int getPeriod();

  /**
   * get the starting point of the timeline.
   *
   * @return int as the starting point
   */
  public int getStartTick();

  /**
   * Get the ending point of the timeline.
   *
   * @return int as ending point
   */
  public int getEndTick();

  /**
   * push the timeline forward with the length of given period.
   *
   * @param period the given length
   * @throws IllegalArgumentException if it can't be push forward at that long or the period is a
   *                                  negative number
   */
  public void pushForward(int period);

  /**
   * push the timeline backward with the length of given period.
   *
   * @param period the given length
   * @throws IllegalArgumentException if the period is a negative number
   */
  public void pushBackward(int period);

  /**
   * extend the timeline to the given point from endpoint to the right.
   *
   * @param endpoint the given point
   */
  public void changeEndTick(int endpoint);

  /**
   * Extend the timeline to the given point from starter point to the left.
   *
   * @param startpoint the given startpoint
   * @throws IllegalArgumentException if the startpoint is greater than the endpoint of the
   *                                  startpoint is less than zero
   */
  public void changeStartTick(int startpoint);

  /**
   * change the color of the shape within this timeLine.
   *
   * @param color the desired color
   */
  public void changeColor(Color color);

  /**
   * change the position of the final shape.
   *
   * @param position the desired position
   */
  public void changePosition(Posn position);

  /**
   * change the size of the final shape.
   *
   * @param width  the width of the shape
   * @param height the height of the shape
   * @throws IllegalArgumentException if the given width and height are invalid.
   */
  public void changeSize(int width, int height);

  /**
   * Get the startshape of this motion.
   *
   * @return the startshape of the motion
   */
  public ProviderShape getStartShape();


  /**
   * get the shape after motion.
   *
   * @return shape the end shape of this motion
   */
  public ProviderShape getEndShape();

  /**
   * check whether the motion has changed the color.
   *
   * @return boolean as true if the color has been changed
   */
  public boolean isChangeColor();

  /**
   * check whether the motion has changed the size.
   *
   * @return true if the size has been changed
   */
  public boolean isChangeSize();

  /**
   * check if this motion had changed the position.
   *
   * @return true if the position has been changed
   */
  public boolean isChangePosition();

  /**
   * Determine if the two motions overlap.
   *
   * @param providerMotion motion
   * @return true if overlap.
   */
  public boolean isOverlap(ProviderMotion providerMotion);

  /**
   * Get shape at the given tick.
   *
   * @param tick tick as int.
   * @return Shape at tick.
   * @throws IllegalArgumentException if given tick is negative.
   */
  public ProviderShape getShape(int tick);


}