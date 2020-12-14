package cs3500.animator.model;

import java.util.Objects;

/**
 * Represents the color that a shape will be animated in using integer values of RGB.
 */
public class Color implements IColor {

  private int r;
  private int g;
  private int b;

  /**
   * Constructs the color that a shape will be animated in.
   *
   * @param r the red value of the color of the shape
   * @param g the green value of the color of the shape
   * @param b the blue value of the color of the shape
   */
  public Color(int r, int g, int b) {
    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("RGB values must be positive and less than 256");
    } else {
      this.r = r;
      this.g = g;
      this.b = b;
    }
  }

  /**
   * Returns the string value of this color.
   *
   * @return the string value of this color
   */
  @Override
  public String toString() {
    return this.r + " " + this.g + " " + this.b;
  }

  /**
   * Returns the rgb(r,g,b) formatted string value of this color.
   *
   * @return the formatted string
   */
  public String fancyString() {
    return "rgb(" + this.r + "," + this.g + "," + this.b + ")";
  }

  /**
   * Computes the amount the color should be changed given the ratio.
   *
   * @param c     the target color
   * @param ratio the percentage of change that should be executed
   * @return the new color
   */
  public IColor change(IColor c, double ratio) {
    return new Color((int) (Math.round(Math.abs(c.paintColor().getRed()) - this.r) * ratio),
        (int) (Math.round(Math.abs(c.paintColor().getGreen()) - this.g) * ratio),
        (int) (Math.round(Math.abs(c.paintColor().getBlue()) - this.b) * ratio));
  }

  /**
   * Adds all the fields of the given color to this color.
   *
   * @param c the color to be added
   * @return the sum of both colors
   */
  public IColor add(IColor c) {
    return new Color(this.r + c.paintColor().getRed(), this.g + c.paintColor().getGreen(),
        this.b + c.paintColor().getBlue());
  }

  public java.awt.Color paintColor() {
    return new java.awt.Color(this.r, this.g, this.b);
  }

  @Override
  public int getRed() {
    return this.r;
  }

  @Override
  public int getBlue() {
    return this.b;
  }

  @Override
  public int getGreen() {
    return this.g;
  }

  /**
   * Determines whether of not the given object is equal to this color.
   *
   * @param o the object to compare the color to.
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
    Color color = (Color) o;
    return r == color.r
        && g == color.g
        && b == color.b;
  }

  /**
   * Returns the hashcode of this color.
   *
   * @return the hashcode of the color
   */
  @Override
  public int hashCode() {
    return Objects.hash(r, g, b);
  }
}
