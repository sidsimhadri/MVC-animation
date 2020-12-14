package cs3500.animator.model;

/**
 * Represents a position.
 */
public interface IPosn {


  /**
   * Adds the given posn to this posn.
   *
   * @param p the posn to be added to this
   * @return the resulting posn of the two posns added together
   */
  IPosn add(IPosn p);

  /**
   * Adds the given posn to this posn.
   *
   * @param x the x to be added to this
   * @param y the y to be added to this.
   * @return the resulting posn of the two posns added together
   */
  IPosn add(int x, int y);

  /**
   * Subtracts the given posn from this posn and multiplies it by the given ratio.
   *
   * @param p     the posn to subtract from this posn
   * @param ratio the ratio to multiply the values by
   * @return the resulting posn from subtracting then multiplying
   */
  IPosn change(IPosn p, double ratio);

  /**
   * Gets the x value of this posn.
   *
   * @return the x value of the posn
   */
  int getX();

  /**
   * Gets the y value of this posn.
   *
   * @return the y value of the posn
   */
  int getY();
}
