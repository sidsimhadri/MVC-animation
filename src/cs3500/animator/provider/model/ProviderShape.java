package cs3500.animator.provider.model;

import cs3500.animator.model.Color;
import cs3500.animator.model.IColor;
import cs3500.animator.model.IPosn;

/**
 * represent a immutable shape.
 */
public interface ProviderShape {

  /**
   * Only change the color of this shape.
   *
   * @param color the desired color
   */
  void changeColor(Color color);

  /**
   * only change the position of this shape.
   *
   * @param position the desired position
   */
  void changePosition(IPosn position);

  /**
   * Only change the dimension of the shape to the given value.
   *
   * @param width  as x value
   * @param height as y value
   * @throws IllegalArgumentException if the given width and height is smaller than 0
   */
  void changeSize(double width, double height);

  /**
   * get the position of the shape.
   *
   * @return Position as the position of the shape.
   */
  IPosn getPosition();

  /**
   * get the color of the shape.
   *
   * @return Color as the color of the shape.
   */
  IColor getColor();

  /**
   * get the width of the shape.
   *
   * @return double as the width of the shape
   */
  double getWidth();

  /**
   * get the height of the shape.
   *
   * @return double as the height of the shape
   */
  double getHeight();

  /**
   * make a copy of the this shape.
   *
   * @return the copied value of the shape
   */
  ProviderShape copyShape();

  /**
   * determine whether the given shape is as the same type as this Shape.
   *
   * @param other the given shape
   * @return boolean as the result
   */
  boolean isSameType(ProviderShape other);

  /**
   * get the name of the type of this shape.
   *
   * @return String as the result
   */
  String getShapeName();

  /**
   * get the string description of the shape.
   *
   * @return a string representation of the shape
   */
  @Override
  String toString();
}
