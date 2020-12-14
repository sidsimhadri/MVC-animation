package cs3500.animator.model;

import cs3500.animator.provider.model.ProviderShape;
import cs3500.animator.view.IViewShape;
import java.util.ArrayList;

/**
 * Contains all information necessary to construct a view shape of each type.
 */
public interface IShape {

  /**
   * Gets the type of this shape.
   *
   * @return the type of this shape
   */
  String getType();

  /**
   * Gets the position of this shape.
   *
   * @return the position of the shape
   */
  IPosn getPos();

  /**
   * Gets the dimensions of this shape.
   *
   * @return the dimensions of the shape
   */
  IPosn getDim();

  /**
   * Gets the color of the shape.
   *
   * @return the color of the shape
   */
  IColor getColor();

  /**
   * Sets the position of the shape to the given position.
   *
   * @param s the position to set the shape at
   */
  void setPos(IPosn s);

  /**
   * returns a copy of this shape with the given posn.
   *
   * @param s the position to set the copy at
   */
  IShape newPos(IPosn s);

  /**
   * Sets the dimensions of the shape to the given dimensions.
   *
   * @param s the dimensions to set the shape to
   */
  void setDim(IPosn s);

  /**
   * Sets the color of the shape to the given color.
   *
   * @param c the color to set the shape to
   */
  void setColor(IColor c);

  /**
   * Sets the motions of the shape to the given motions.
   *
   * @param m the list of motions to set the shape to
   */
  void setMotions(ArrayList<IMotion> m);

  /**
   * Gets the name of the shape.
   *
   * @return the name of the shape
   */
  String getName();

  /**
   * Adds a motion to the shape.
   *
   * @param m the motion to be added to the shape
   */
  void addMotion(IMotion m);

  /**
   * Renders the shape at the given time stamp.
   *
   * @param timeStamp the time at which to render the shape
   * @return the shape rendered at the given time
   */
  IShape renderShape(int timeStamp);

  /**
   * Gets the motions of the shape.
   *
   * @return a list of motions of the shape
   */
  ArrayList<IMotion> getMotions();

  /**
   * Converts the shape to an  IViewShape that is compatible with the view.
   *
   * @return the converted IViewShape
   */
  IViewShape convert();

  /**
   * Returns the lastTick of this shapes motions.
   *
   * @return the last tick of this shapes motions/
   */
  int lastTick();


  /**
   * Converts this shape to the appropriate implementation of the Customer's AbstractShape class.
   *
   * @return the converted customershape
   */
  ProviderShape customer();
}
