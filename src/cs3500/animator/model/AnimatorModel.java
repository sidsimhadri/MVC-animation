package cs3500.animator.model;

import cs3500.animator.util.AnimationBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an AnimatorModel that will animate a desired animation. Class Invariant: The frame of
 * the model will always be positive The posn constructor enforces this invariant and there is a
 * test to show that it does
 */
public class AnimatorModel implements IAnimatorModel {

  private final Posn topCorner;
  private ArrayList<IShape> shapes;
  private final Posn size;

  /**
   * Constructs a AnimatorModel with the given params.
   *
   * @param shapes    a list of shapes that will be animated
   * @param size      the size of the frame of the animation
   * @param topCorner the coordinates of the top Corner.
   */
  public AnimatorModel(ArrayList<IShape> shapes, Posn size, Posn topCorner) {
    this.shapes = shapes;
    this.size = size;
    this.topCorner = topCorner;
  }

  /**
   * Constructs a AnimatorModel with the given params.
   *
   * @param shapes a list of shapes that will be animated
   * @param size   the size of the frame of the animation
   */
  public AnimatorModel(ArrayList<IShape> shapes, Posn size) {
    this.shapes = shapes;
    this.size = size;
    this.topCorner = new Posn(0, 0);
  }

  /**
   * Constructs an AnimatorModel with no shapes.
   *
   * @param size the size of the frame of the animation
   */
  public AnimatorModel(Posn size) {
    this.shapes = new ArrayList<IShape>();
    this.size = size;
    this.topCorner = new Posn(0, 0);
  }

  /**
   * Constructs an AnimatorModel with no shapes and size 200, 200, and no offset.
   */
  public AnimatorModel() {
    this.shapes = new ArrayList<IShape>();
    this.size = new Posn(200, 200);
    this.topCorner = new Posn(0, 0);
  }

  /**
   * Represents a builder that can build an animation model.
   */
  public static final class Builder implements AnimationBuilder<IAnimatorModel> {

    private static ArrayList<IShape> shapes;
    private static Posn size;
    private static Posn topCorner;

    /**
     * Constructs a final document.
     */
    public Builder() {
      this.shapes = new ArrayList<>();
      this.size = new Posn(0, 0);
      this.topCorner = new Posn(0, 0);
    }

    @Override
    public IAnimatorModel build() {
      return new AnimatorModel(this.shapes, this.size, this.topCorner);
    }

    @Override
    public AnimationBuilder<IAnimatorModel> setBounds(int x, int y, int width, int height) {
      size = new Posn(width, height);
      topCorner = new Posn(x, y);
      return this;
    }

    @Override
    public AnimationBuilder<IAnimatorModel> declareShape(String name, String type) {
      shapes.add(new Shape(name, type));
      return this;
    }

    @Override
    public AnimationBuilder<IAnimatorModel> addMotion(String name, int t1, int x1, int y1, int w1,
        int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2,
        int b2) {

      IShape shape = null;
      for (IShape s : shapes) {
        if (s.getName().compareToIgnoreCase(name) == 0) {

          shape = s;
          break;
        }
      }
      if (shape == null) {
        throw new IllegalArgumentException("There is no shape with that name");

      } else {
        shape.addMotion(
            new Motion(t1, t2, new Shape(name, shape.getType(), new Posn(x1, y1),
                new Posn(w1, h1), new Color(r1, g1, b1)),
                new Shape(name, shape.getType(), new Posn(x2, y2),
                    new Posn(w2, h2), new Color(r2, g2, b2))));
        return this;
      }

    }

  }


  /**
   * Adds the given shape to the AnimatorModel.
   *
   * @param name the name of the shape
   * @param type the type of shape
   * @param x    the x coordinate
   * @param y    the y coordinate
   * @param w    the width
   * @param h    the height
   * @param r    the red value
   * @param g    the green value
   * @param b    the blue value
   */
  @Override
  public void addShape(String name, String type, int x, int y, int w, int h, int r, int g, int b) {
    this.shapes.add(new Shape(name, type, new Posn(x, y), new Posn(w, h), new Color(r, g, b)));
  }

  @Override
  public void removeShape(String name) {
    IShape remove = null;
    for (IShape s : this.shapes) {
      if (s.getName().compareToIgnoreCase(name) == 0) {
        remove = s;
        break;
      }
    }
    if (remove == null) {
      throw new IllegalArgumentException("There is no shape with that name");
    } else {
      this.shapes.remove(remove);
    }


  }

  /**
   * Adds a motion to the AnimatorModel.
   *
   * @param name the name of the shape that the motion will be added to
   * @param t1   the initial time
   * @param x1   the inital x
   * @param y1   the initial y
   * @param w1   the initial width
   * @param h1   the initial height
   * @param r1   the initial red value
   * @param g1   the initial green value
   * @param b1   the initial blue value
   * @param t2   the final time
   * @param x2   the final x
   * @param y2   the final y
   * @param w2   the final width
   * @param h2   the final height
   * @param r2   the final red value
   * @param g2   the final green value
   * @param b2   the final blue value
   */
  @Override
  public void addMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
      int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    IShape shape = null;
    for (IShape s : this.shapes) {
      if (s.getName().compareToIgnoreCase(name) == 0) {
        shape = s;
        break;
      }
    }
    if (shape == null) {
      throw new IllegalArgumentException("There is no shape with that name");

    } else {
      shape.addMotion(
          new Motion(t1, t2, new Shape(name, shape.getType(), new Posn(x1, y1),
              new Posn(w1, h1), new Color(r1, g1, b1)),
              new Shape(name, shape.getType(), new Posn(x2, y2),
                  new Posn(w2, h2), new Color(r2, g2, b2))));
    }
  }


  @Override
  public List<IShape> renderShapes(int timeStamp) {
    ArrayList<IShape> renders = new ArrayList<IShape>();
    for (IShape s : this.shapes) {
      try {
        renders.add(s.renderShape(timeStamp));
      } catch (IllegalArgumentException e) {
        System.out.println("Shape " + s.getName() + " does not have a motion at this timestamp");
      }
    }
    return renders;
  }

  @Override
  public int getY() {
    return this.size.getY();
  }

  @Override
  public int getX() {
    return this.size.getX();
  }

  /**
   * Gets the x origin of the model.
   *
   * @return the x origin of the model frame
   */
  @Override
  public int getTopX() {
    return this.topCorner.getX();
  }

  /**
   * Gets the y origin of the model frame.
   *
   * @return the y origin of the model frame
   */
  @Override
  public int getTopY() {
    return this.topCorner.getY();
  }

  @Override
  public ArrayList<IShape> getShapes() {
    return this.shapes;
  }

  @Override
  public int lastTick() {
    int lastTick = 0;
    for (IShape s : this.shapes) {
      lastTick = Math.max(lastTick, s.lastTick());
    }
    return lastTick;
  }

  @Override
  public String toString() {
    String result = "";
    for (IShape s : this.shapes) {
      result += (s.toString() + "\n");
    }
    return result;
  }
}

