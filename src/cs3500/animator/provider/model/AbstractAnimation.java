package cs3500.animator.provider.model;

import cs3500.animator.model.Canvas;
import cs3500.animator.model.Color;
import cs3500.animator.model.IAnimatorModel;
import cs3500.animator.model.IMotion;
import cs3500.animator.model.IShape;
import cs3500.animator.model.Posn;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//I named it abstract because the provider used this name in their view and I didn't want to change
// their view

/**
 * My implementation for the providers model.
 *
 * @param <K> List<ProviderMotion></ProviderMotion>
 */
public class AbstractAnimation<K> implements Animation<List<ProviderMotion>> {


  private IAnimatorModel model;


  public AbstractAnimation(IAnimatorModel model) {
    this.model = model;

  }

  /**
   * Add a shape to this animation with given name. Associated with the shape is a list of motions
   * that will be set to be empty and motions will be added later.
   *
   * @param name as the name of the shape
   * @param type as the type of ths shape
   * @throws IllegalArgumentException if the name already exist.
   */
  @Override
  public void declareShape(String name, String type) {
    model.addShape(name, type, 0, 0, 0, 0, 0, 0, 0);
  }

  /**
   * Add a new motion to the shape with given name.
   *
   * @param name           the name of the shape
   * @param providerMotion a new motion
   * @throws IllegalArgumentException if couldn't find the name or the motion can't be added
   */
  @Override
  public void addMotion(String name, ProviderMotion providerMotion) {
    model.addMotion(name, providerMotion.getStartTick(),
        providerMotion.getStartShape().getPosition().getX(),
        providerMotion.getStartShape().getPosition().getY(),
        (int) providerMotion.getStartShape().getWidth(),
        (int) providerMotion.getStartShape().getHeight(),
        providerMotion.getStartShape().getColor().getRed(),
        providerMotion.getStartShape().getColor().getGreen(),
        providerMotion.getStartShape().getColor()
            .getBlue(), providerMotion.getEndTick(),
        providerMotion.getEndShape().getPosition().getX(),
        providerMotion.getEndShape().getPosition().getY(),
        (int) providerMotion.getEndShape().getWidth(),
        (int) providerMotion.getEndShape().getHeight(),
        providerMotion.getEndShape().getColor().getRed(),
        providerMotion.getEndShape().getColor().getGreen(), providerMotion.getEndShape().getColor()
            .getBlue());
  }


  /**
   * Delete a shape and all its motion as the name specified.
   *
   * @param name the name of the shape
   * @throws IllegalArgumentException if couldn't find such shape
   */
  @Override
  public void deleteShape(String name) {
    this.model.removeShape(name);
  }

  /**
   * Delete all motion from the given startTick.
   *
   * @param name      the given name of the shape
   * @param startTick the start time of the desired shape that we want to change
   * @throws IllegalArgumentException if the move can't be made, for example if the start tick
   *                                  cannot be found or the delete will causes the motion to be
   *                                  illogical
   */
  @Override
  public void deleteMotion(String name, int startTick) {
    throw new UnsupportedOperationException("this method is never called");
  }

  /**
   * change the color of shape in the motion of given timeline.
   *
   * @param name      the name of the shape
   * @param color     the color to change
   * @param startTick the start point of the time line
   * @throws IllegalArgumentException if the motion cannot be found with the time line or the name
   *                                  of the motion does not exist in the animation.
   */
  @Override
  public void changeColor(String name, Color color, int startTick) {
    throw new UnsupportedOperationException("this method is never called");
  }

  /**
   * Make a change of position to an existed motion.
   *
   * @param name      the name of the shape
   * @param position  the position to change
   * @param startTick the start point of the time line
   * @throws IllegalArgumentException if the motion cannot be found with the time line or the name
   *                                  of the motion does not exist in the animation
   */
  @Override
  public void changePosition(String name, Posn position, int startTick) {
    throw new UnsupportedOperationException("this method is never called");
  }

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
  @Override
  public void changeSize(String name, int width, int height, int startTick) {
    throw new UnsupportedOperationException("this method is never called");
  }

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
  @Override
  public void changeSpeedAnchorStartPoint(String name, int startTick, int endTick) {
    throw new UnsupportedOperationException("this method is never called");
  }

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
  @Override
  public void changeSpeedAnchorEndPoint(String name, int startTick, int endTick) {
    throw new UnsupportedOperationException("this method is never called");
  }

  /**
   * get all the shapes and its motion ready to play, which means it order by the time of
   * appearance.
   *
   * @return Map the current model state of the animation.
   */
  @Override
  public Map<String, List<ProviderMotion>> getAnimate() {
    Map<String, List<ProviderMotion>> result = new LinkedHashMap<String, List<ProviderMotion>>();
    for (IShape s : model.getShapes()) {
      ArrayList<ProviderMotion> motions = new ArrayList<>();
      for (IMotion m : s.getMotions()) {
        motions.add(m.convert());
      }
      result.put(s.getName(), motions);
    }
    return result;
  }

  /**
   * get the motion sequence of a shape.
   *
   * @param name the name of the shape
   * @return K as sequence of motions
   */
  @Override
  public List<ProviderMotion> getSequence(String name) {
    ArrayList<ProviderMotion> result = new ArrayList<>();
    for (IShape s : model.getShapes()) {
      if (s.getName().compareTo(name) == 0) {
        for (IMotion m : s.getMotions()) {
          result.add(m.convert());
        }
      }
    }
    return result;
  }

  /**
   * compute the length of this animation.
   *
   * @return int as the longest end tick of all motions inside of the animation.
   */
  @Override
  public int getLength() {
    return this.model.lastTick();
  }

  /**
   * Get the start time of this animation.
   *
   * @return int as the shortest start tick of all motions inside of the animation.
   */
  @Override
  public int getStartTime() {
    throw new UnsupportedOperationException("this method is never called");
  }

  /**
   * setter for canvas.
   *
   * @param canvas the canvas to set. 
   */
  @Override
  public void setCanvas(Canvas canvas) {
    throw new UnsupportedOperationException("this method is never called");
  }

  /**
   * get the dimension for canvas of this animation.
   *
   * @return Canvas the canvas to return
   */
  @Override
  public Canvas getCanvas() {
    return new Canvas(model.getTopX(), model.getTopY(), model.getX(), model.getY());
  }

  /**
   * get the type of the shape whose name match the given name.
   *
   * @param name the given name
   * @return ShapeType
   */
  @Override
  public ShapeType getShapeType(String name) {
    for (IShape s : this.model.getShapes()) {
      if (s.getName().compareTo(name) == 0) {
        return ShapeType.findShapeType(s.getType());
      }

    }
    return null;
  }

  /**
   * get all shapes at specific tick.
   *
   * @param tick some tick
   * @return shapes need to display
   */
  @Override
  public List<ProviderShape> getShapes(int tick) {
    List<ProviderShape> result = new ArrayList<>();
    for (IShape s : this.model.renderShapes(tick)) {
      result.add(s.customer());
    }
    return result;
  }


}
