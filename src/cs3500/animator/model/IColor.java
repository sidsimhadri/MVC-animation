package cs3500.animator.model;

/**
 * Represents a color that can be converted to an AWT color.
 */
public interface IColor {

  /**
   * Returns the rgb(r,g,b) formatted string value of this color.
   *
   * @return the formatted string
   */
  String fancyString();

  /**
   * Computes the amount the color should be changed given the ratio.
   *
   * @param c     the target color
   * @param ratio the percentage of change that should be executed
   * @return the new color
   */
  IColor change(IColor c, double ratio);

  /**
   * Adds all the fields of the given color to this color.
   *
   * @param c the color to be added
   * @return the sum of both colors
   */
  IColor add(IColor c);

  /**
   * Creates a java awt color object with the values of this color.
   *
   * @return the java.awt.Color produced
   */
  java.awt.Color paintColor();

  /**
   * gets the red value.
   *
   * @return this.r
   */
  int getRed();

  /**
   * gets the blue value.
   *
   * @return this.b
   */
  int getBlue();

  /**
   * gets the green value.
   *
   * @return this.g
   */
  int getGreen();
}
