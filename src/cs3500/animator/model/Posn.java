package cs3500.animator.model;

import java.util.Objects;

/**
 * Represents a Posn with an x and y value where x and y must be positive. Can represent the
 * position of a shape. Can represent the dimensions of a shape. Can represent the size of the
 * animation's frame.
 */
public class Posn implements IPosn {

  private int x;
  private int y;

  /**
   * Constructs a Posn.
   *
   * @param x the horizontal location of the Posn
   * @param y the vertical location of the Posn
   */
  public Posn(int x, int y) {

    this.x = x;
    this.y = y;
  }

  /**
   * Outputs this posn as a string.
   *
   * @return the string value of this posn
   */
  @Override
  public String toString() {
    return this.x + " " + this.y;
  }

  /**
   * Adds the given posn to this posn.
   *
   * @param p the posn to be added to this
   * @return the resulting posn of the two posns added together
   */
  public IPosn add(IPosn p) {
    return new Posn((this.x + p.getX()), (this.y + p.getY()));
  }

  /**
   * Adds the given posn to this posn.
   *
   * @param x the x to be added to this
   * @param y the y to be added to this.
   * @return the resulting posn of the two posns added together
   */
  public IPosn add(int x, int y) {
    return new Posn((this.x + x), (this.y + y));
  }

  /**
   * Subtracts the given posn from this posn and multiplies it by the given ratio.
   *
   * @param p     the posn to subtract from this posn
   * @param ratio the ratio to multiply the values by
   * @return the resulting posn from subtracting then multiplying
   * @throws IllegalArgumentException if the posn returned is a negative value
   */
  public IPosn change(IPosn p, double ratio) throws IllegalArgumentException {
    return new Posn((int) ((this.x - p.getX()) * ratio), (int) ((this.y - p.getY()) * ratio));
  }

  /**
   * Gets the x value of this posn.
   *
   * @return the x value of the posn
   */
  public int getX() {
    return x;
  }

  /**
   * Gets the y value of this posn.
   *
   * @return the y value of the posn
   */
  public int getY() {
    return y;
  }

  /**
   * Determines whether or not the given object is equal to this posn.
   *
   * @param o the object to compare this posn to
   * @return true if they are equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Posn posn = (Posn) o;
    return x == posn.x
        && y == posn.y;
  }

  /**
   * Returns the hashcode of this posn.
   *
   * @return the hashcode of this posn
   */
  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
