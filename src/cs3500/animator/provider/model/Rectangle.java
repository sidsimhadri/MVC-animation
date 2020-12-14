package cs3500.animator.provider.model;

import cs3500.animator.model.IColor;
import cs3500.animator.model.IPosn;
import cs3500.animator.model.IShape;

/**
 * My implementation for the provider's rectangle.
 */
public class Rectangle extends AbstractShape implements ProviderShape {


  public Rectangle(double width, double height, IColor color, IPosn pos) {
    super(width, height, color, pos);
  }

  public Rectangle(IShape s) {
    super(s.getDim().getX(), s.getDim().getY(), s.getColor(), s.getPos());
  }

  /**
   * make a copy of the this shape.
   *
   * @return the copied value of the shape
   */
  @Override
  public ProviderShape copyShape() {
    return new Rectangle(this.getWidth(), this.getHeight(), this.getColor(), this.getPosition());
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

  /**
   * get the name of the type of this shape.
   *
   * @return String as the result
   */
  @Override
  public String getShapeName() {
    return "rectangle";
  }


}
