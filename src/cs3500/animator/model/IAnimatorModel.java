package cs3500.animator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an AnimatorModel interface. Enforces the conditions and handeles all the variables  of
 * a model for an animation.
 */
public interface IAnimatorModel {

  /**
   * Adds the given shape to the AnimatorModel.
   *
   * @param name the name of the shape to be added
   * @param type the type of shape to be added
   */
  void addShape(String name, String type,
      int x, int y, int w, int h, int r, int g, int b);

  /**
   * Removes the shape with given name from the AnimatorModel.
   *
   * @param name the name of the shape that is to be removed
   */
  void removeShape(String name);

  /**
   * Adds a motion to the AnimatorModel.
   *
   * @param name the name of the shape that the motion will be added to
   * @param t1   The start time of this transformation
   * @param x1   The initial x-position of the shape
   * @param y1   The initial y-position of the shape
   * @param w1   The initial width of the shape
   * @param h1   The initial height of the shape
   * @param r1   The initial red color-value of the shape
   * @param g1   The initial green color-value of the shape
   * @param b1   The initial blue color-value of the shape
   * @param t2   The end time of this transformation
   * @param x2   The final x-position of the shape
   * @param y2   The final y-position of the shape
   * @param w2   The final width of the shape
   * @param h2   The final height of the shape
   * @param r2   The final red color-value of the shape
   * @param g2   The final green color-value of the shape
   * @param b2   The final blue color-value of the shape
   */
  void addMotion(String name,
      int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
      int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2);

  /**
   * Renders the shapes at the given time stamp.
   *
   * @param timeStamp the time to render the shapes
   * @return the list of shapes rendered at that time stamp
   */
  List<IShape> renderShapes(int timeStamp);

  /**
   * Gets the height of the model frame.
   *
   * @return the height of the model frame
   */
  int getY();

  /**
   * Gets the width of the model frame.
   *
   * @return the width of the model frame
   */
  int getX();

  /**
   * Gets the x origin of the model.
   *
   * @return the x origin of the model frame
   */
  int getTopX();

  /**
   * Gets the y origin of the model frame.
   *
   * @return the y origin of the model frame
   */
  int getTopY();

  /**
   * Returns the shapes for this model.
   *
   * @return the shapes of this model
   */
  ArrayList<IShape> getShapes();

  /**
   * Returns the last tick of the shapes in this model.
   *
   * @return the last tick of the shapes in this model.
   */
  int lastTick();
}

