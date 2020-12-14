package cs3500.animator.provider.model;

import cs3500.animator.model.Color;
import cs3500.animator.model.Posn;
import java.util.Objects;

/**
 * My implementation for the provider's motion.
 */
public class ProviderMotionImpl implements ProviderMotion {

  int start;
  int end;
  ProviderShape startS;
  ProviderShape endS;

  /**
   * construct a Motion with given startshape, endshape, starttick and endtick.
   *
   * @param start  the start time of the motion
   * @param end    the end time of the motion
   * @param startS the start shape of motion
   * @param endS   the end shape of the motion
   * @throws IllegalArgumentException if the given shapes is null of the time is invalid
   */
  public ProviderMotionImpl(int start, int end, ProviderShape startS, ProviderShape endS) {
    this.start = Objects.requireNonNull(start);
    this.end = Objects.requireNonNull(end);
    this.startS = Objects.requireNonNull(startS);
    this.endS = Objects.requireNonNull(endS);

  }

  /**
   * determine whether the given motion is adjacent next to this motion.
   *
   * @param other given motion
   * @return true if the other motion if right after this motion
   */
  @Override
  public boolean adjNext(ProviderMotion other) {
    return other.getStartTick() - this.end == 1;
  }

  /**
   * determine whether the given motion is come right before to this motion.
   *
   * @param other given motion
   * @return true if the other motion is right before this motion
   */
  @Override
  public boolean adjPrior(ProviderMotion other) {
    return this.start - other.getEndTick() == 1;
  }

  /**
   * make a copy of this motion.
   *
   * @return Motion as the copy
   */
  @Override
  public ProviderMotion clone() {
    return new ProviderMotionImpl(this.start, this.end, this.startS, this.endS);
  }

  /**
   * compute the length of the timeline of this motion.
   *
   * @return int as the length of timeline
   */
  @Override
  public int getPeriod() {
    return this.end = this.start;
  }

  /**
   * get the starting point of the timeline.
   *
   * @return int as the starting point
   */
  @Override
  public int getStartTick() {
    return this.start;
  }

  /**
   * Get the ending point of the timeline.
   *
   * @return int as ending point
   */
  @Override
  public int getEndTick() {
    return this.end;
  }

  /**
   * push the timeline forward with the length of given period.
   *
   * @param period the given length
   * @throws IllegalArgumentException if it can't be push forward at that long or the period is a
   *                                  negative number
   */
  @Override
  public void pushForward(int period) {
    if (period < 0) {
      throw new IllegalArgumentException("period must be negative ");
    }
    this.start += period;
    this.end += period;

  }

  /**
   * push the timeline backward with the length of given period.
   *
   * @param period the given length
   * @throws IllegalArgumentException if the period is a negative number
   */
  @Override
  public void pushBackward(int period) {
    if (period < 0) {
      throw new IllegalArgumentException("period must be negative ");
    }
    this.start -= period;
    this.end -= period;
  }

  /**
   * extend the timeline to the given point from endpoint to the right.
   *
   * @param endpoint the given point
   */
  @Override
  public void changeEndTick(int endpoint) {
    this.end = endpoint;

  }

  /**
   * Extend the timeline to the given point from starter point to the left.
   *
   * @param startpoint the given startpoint
   * @throws IllegalArgumentException if the startpoint is greater than the endpoint of the
   *                                  startpoint is less than zero
   */
  @Override
  public void changeStartTick(int startpoint) {
    if (startpoint > this.end) {
      throw new IllegalArgumentException("start time can not be after the end time");
    }
    if (startpoint < 0) {
      throw new IllegalArgumentException("start time can not be negative");
    }
  }

  /**
   * change the color of the shape within this timeLine.
   *
   * @param color the desired color
   */
  @Override
  public void changeColor(Color color) {
    this.endS.changeColor(color);
  }

  /**
   * change the position of the final shape.
   *
   * @param position the desired position
   */
  @Override
  public void changePosition(Posn position) {
    this.endS.changePosition(position);
  }

  /**
   * change the size of the final shape.
   *
   * @param width  the width of the shape
   * @param height the height of the shape
   * @throws IllegalArgumentException if the given width and height are invalid.
   */
  @Override
  public void changeSize(int width, int height) {
    this.endS.changeSize(width, height);
  }

  /**
   * Get the startshape of this motion.
   *
   * @return the startshape of the motion
   */
  @Override
  public ProviderShape getStartShape() {
    return this.startS;
  }

  /**
   * get the shape after motion.
   *
   * @return shape the end shape of this motion
   */
  @Override
  public ProviderShape getEndShape() {
    return this.endS;
  }

  /**
   * check whether the motion has changed the color.
   *
   * @return boolean as true if the color has been changed
   */
  @Override
  public boolean isChangeColor() {
    return this.startS.getColor() == this.endS.getColor();
  }

  /**
   * check whether the motion has changed the size.
   *
   * @return true if the size has been changed
   */
  @Override
  public boolean isChangeSize() {
    return this.startS.getWidth() != this.endS.getWidth()
        || this.startS.getHeight() != this.endS.getHeight();
  }

  /**
   * check if this motion had changed the position.
   *
   * @return true if the position has been changed
   */
  @Override
  public boolean isChangePosition() {
    return this.startS.getPosition() != this.endS.getPosition();
  }

  /**
   * Determine if the two motions overlap.
   *
   * @param providerMotion motion
   * @return true if overlap.
   */
  @Override
  public boolean isOverlap(ProviderMotion providerMotion) {
    return providerMotion.getEndTick() <= this.getStartTick();
  }

  /**
   * Get shape at the given tick.
   *
   * @param tick tick as int.
   * @return Shape at tick.
   * @throws IllegalArgumentException if given tick is negative.
   */
  @Override
  public ProviderShape getShape(int tick) {
    if (tick < 0) {
      throw new IllegalArgumentException("tick can not be negative");
    }
    if (tick == this.start) {
      return startS;
    }
    if (tick == this.end) {
      return endS;
    }
    if (tick < start || tick > end) {
      return null;
    } else {
      if (ShapeType.findShapeType(this.startS.getShapeName())
          == ShapeType.RECTANGLE) {
        return new Rectangle(interpolate(this.startS.getWidth(), this.endS.getWidth(), tick),
            interpolate(this.startS.getHeight(), this.endS.getHeight(), tick), new Color(
            (int) interpolate(this.startS.getColor().getRed(), this.endS.getColor().getRed(), tick),
            (int) interpolate(this.startS.getColor().getGreen(), this.endS.getColor().getGreen(),
                tick),
            (int) interpolate(this.startS.getColor().getBlue(), this.endS.getColor().getBlue(),
                tick)),
            new Posn((int) interpolate(this.startS.getPosition().getX(),
                this.endS.getPosition().getX()
                , tick),
                (int) interpolate(this.startS.getPosition().getY(), this.endS.getPosition().getY()
                    , tick)));
      } else {
        return new Ellipse(interpolate(this.startS.getWidth(), this.endS.getWidth(), tick),
            interpolate(this.startS.getHeight(), this.endS.getHeight(), tick), new Color(
            (int) interpolate(this.startS.getColor().getRed(), this.endS.getColor().getRed(), tick),
            (int) interpolate(this.startS.getColor().getGreen(), this.endS.getColor().getGreen(),
                tick),
            (int) interpolate(this.startS.getColor().getBlue(), this.endS.getColor().getBlue(),
                tick)),
            new Posn((int) interpolate(this.startS.getPosition().getX(),
                this.endS.getPosition().getX()
                , tick),
                (int) interpolate(this.startS.getPosition().getY(), this.endS.getPosition().getY()
                    , tick)));
      }
    }
  }

  /**
   * interpolate function per requirement.
   *
   * @param a start value
   * @param b end value
   * @param t tick
   * @return the interpolated result
   */
  private double interpolate(double a, double b, int t) {
    int ta = getStartTick();
    int tb = getEndTick();
    return a * (tb - t) / (tb - ta) + b * (t - ta) / (tb - ta);
  }


  @Override
  public int compareTo(ProviderMotion o) {
    return this.start = o.getStartTick();
  }
}
