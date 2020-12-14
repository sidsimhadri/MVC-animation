package cs3500.animator.provider.model;

import cs3500.animator.model.Color;
import cs3500.animator.model.IColor;
import cs3500.animator.model.IPosn;
import java.util.Objects;

/**
 * My implementation for the provider's shape class.
 */
public abstract class AbstractShape implements ProviderShape {


  private double width;
  private double height;
  private IColor color;
  private IPosn pos;


  /**
   * Constructs a shape with the given properties.
   *
   * @param width  the width of the shape to construct
   * @param height the height of the shape to construct
   * @param color  the color of the shape to construct
   * @param pos    the posn of the shape to construct
   */
  public AbstractShape(double width, double height, IColor color, IPosn pos) {
    this.pos = Objects.requireNonNull(pos);
    this.color = Objects.requireNonNull(color);
    this.width = width;
    this.height = height;
  }

  /**
   * Only change the color of this shape.
   *
   * @param color the desired color
   */
  @Override
  public void changeColor(Color color) {
    this.color = color;
  }

  /**
   * only change the position of this shape.
   *
   * @param position the desired position
   */
  @Override
  public void changePosition(IPosn position) {
    this.pos = position;
  }

  /**
   * Only change the dimension of the shape to the given value.
   *
   * @param width  as x value
   * @param height as y value
   * @throws IllegalArgumentException if the given width and height is smaller than 0
   */
  @Override
  public void changeSize(double width, double height) {
    this.width = width;
    this.height = height;
  }

  /**
   * get the position of the shape.
   *
   * @return Position as the position of the shape.
   */
  @Override
  public IPosn getPosition() {
    return this.pos;
  }

  /**
   * get the color of the shape.
   *
   * @return Color as the color of the shape.
   */
  @Override
  public IColor getColor() {
    return this.color;
  }

  /**
   * get the width of the shape.
   *
   * @return double as the width of the shape
   */
  @Override
  public double getWidth() {
    return this.width;
  }

  /**
   * get the height of the shape.
   *
   * @return double as the height of the shape
   */
  @Override
  public double getHeight() {
    return this.height;
  }


  /**
   * determine whether the given shape is as the same type as this Shape.
   *
   * @param other the given shape
   * @return boolean as the result
   */
  @Override
  public boolean isSameType(ProviderShape other) {
    return this.getShapeName().compareTo(other.getShapeName()) == 0;
  }


}
