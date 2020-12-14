package cs3500.animator.provider.model;


import cs3500.animator.model.Canvas;
import cs3500.animator.model.Color;
import cs3500.animator.model.Posn;
import java.util.List;
import java.util.Map;

/**
 * Represent an animation that allows multiple shapes conducting multiple movement. Work as Model of
 * this project. An animation has a list of shapes, and each shape has a list of motions.
 *
 * @param <K> the sequence of motions.
 */
public interface Animation<K> {

  /**
   * Add a shape to this animation with given name. Associated with the shape is a list of motions
   * that will be set to be empty and motions will be added later.
   *
   * @param name as the name of the shape
   * @param type as the type of ths shape
   * @throws IllegalArgumentException if the name already exist.
   */
  void declareShape(String name, String type);

  /**
   * Add a new motion to the shape with given name.
   *
   * @param name           the name of the shape
   * @param providerMotion a new motion
   * @throws IllegalArgumentException if couldn't find the name or the motion can't be added
   */
  void addMotion(String name, ProviderMotion providerMotion);


  /**
   * Delete a shape and all its motion as the name specified.
   *
   * @param name the name of the shape
   * @throws IllegalArgumentException if couldn't find such shape
   */
  void deleteShape(String name);

  /**
   * Delete all motion from the given startTick.
   *
   * @param name      the given name of the shape
   * @param startTick the start time of the desired shape that we want to change
   * @throws IllegalArgumentException if the move can't be made, for example if the start tick
   *                                  cannot be found or the delete will causes the motion to be
   *                                  illogical
   */
  void deleteMotion(String name, int startTick);


  /**
   * change the color of shape in the motion of given timeline.
   *
   * @param name      the name of the shape
   * @param color     the color to change
   * @param startTick the start point of the time line
   * @throws IllegalArgumentException if the motion cannot be found with the time line or the name
   *                                  of the motion does not exist in the animation.
   */
  void changeColor(String name, Color color, int startTick);

  /**
   * Make a change of position to an existed motion.
   *
   * @param name      the name of the shape
   * @param position  the position to change
   * @param startTick the start point of the time line
   * @throws IllegalArgumentException if the motion cannot be found with the time line or the name
   *                                  of the motion does not exist in the animation
   */
  void changePosition(String name, Posn position, int startTick);

  /**
   * Make a change of the size of  to an existed motion.
   *
   * @param name      the name of the shape
   * @param width     the width to change
   * @param height    the height to change
   * @param startTick the start point of the time line
   * @throws IllegalArgumentException if the motion cannot be found with the timeline or the name of
   *                                  the motion does not exist in the animation
   */
  void changeSize(String name, int width, int height, int startTick);

  /**
   * change the ending point of the motion whose start point as given to the point as given
   * endTick.
   *
   * @param name      the name of the shape
   * @param startTick the start tick to find
   * @param endTick   the end tick to change
   * @throws IllegalArgumentException if the end tick does not exist in any motions in the given
   *                                  sequence of the given shape, or the name cannot be found in
   *                                  the animation
   */
  void changeSpeedAnchorStartPoint(String name, int startTick, int endTick);

  /**
   * change the starting point of the motion whose end point as given enTick to the point as given
   * startTick.
   *
   * @param name      the name of the shape
   * @param startTick the start tick to find
   * @param endTick   the end tick to change
   * @throws IllegalArgumentException if the end tick does not exist in any motions in the given
   *                                  sequence of the given shape, or the name cannot be found in
   *                                  the animation
   */
  void changeSpeedAnchorEndPoint(String name, int startTick, int endTick);

  /**
   * get all the shapes and its motion ready to play, which means it order by the time of
   * appearance.
   *
   * @return Map the current model state of the animation.
   */
  Map<String, K> getAnimate();


  /**
   * get the motion sequence of a shape.
   *
   * @param name the name of the shape
   * @return K as sequence of motions
   */
  K getSequence(String name);

  /**
   * compute the length of this animation.
   *
   * @return int as the longest end tick of all motions inside of the animation.
   */
  int getLength();

  /**
   * Get the start time of this animation.
   *
   * @return int as the shortest start tick of all motions inside of the animation.
   */
  int getStartTime();

  /**
   * setter for canvas.
   */
  void setCanvas(Canvas canvas);

  /**
   * get the dimension for canvas of this animation.
   *
   * @return Canvas
   */
  Canvas getCanvas();

  /**
   * get the type of the shape whose name match the given name.
   *
   * @param name the given name
   * @return ShapeType
   */
  ShapeType getShapeType(String name);

  /**
   * Rendering model.
   *
   * @return the text output rendering of the model according to the format given in Section 2.1,
   */
  @Override
  String toString();


  /**
   * get all shapes at specific tick.
   *
   * @param tick some tick
   * @return shapes need to display
   */
  List<ProviderShape> getShapes(int tick);


}