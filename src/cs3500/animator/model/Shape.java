package cs3500.animator.model;

import cs3500.animator.provider.model.ProviderShape;
import cs3500.animator.provider.model.Ellipse;
import cs3500.animator.provider.model.Rectangle;
import cs3500.animator.view.IViewShape;
import cs3500.animator.view.ViewOval;
import cs3500.animator.view.ViewRect;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Represents an abstract class of shapes to be animated.
 */
public class Shape implements IShape {

  private String type;
  private IPosn pos;
  private IPosn dim;
  private IColor color;
  private String name;
  private ArrayList<IMotion> motions;

  /**
   * Constructs a shape that is to be animated.
   *
   * @param name  the name of the shape
   * @param pos   the position the shape is located at
   * @param dim   the dimensions of the shape
   * @param color the color of the shape
   */
  public Shape(String name, String type, IPosn pos, IPosn dim, IColor color) {

    this.type = type;
    this.name = name;
    this.pos = pos;
    this.dim = dim;
    this.color = color;
    this.motions = new ArrayList<>();
  }

  /**
   * Constructs a shape with no color, size, or dimensions.
   *
   * @param name the name of the shape
   * @param type the type of shape
   */
  public Shape(String name, String type) {

    this.type = type;
    this.name = name;
    this.pos = new Posn(0, 0);
    this.dim = new Posn(0, 0);
    this.color = new Color(0, 0, 0);
    this.motions = new ArrayList<>();
  }

  /**
   * Constructs a shape that includes a list of motions that is to be animated.
   *
   * @param name    the name of the shape
   * @param pos     the position the shape is located at
   * @param dim     the dimensions of the shape
   * @param color   the color of the shape
   * @param motions a list of motions associated with the shape
   */
  public Shape(String type, String name, IPosn pos, IPosn dim, IColor color,
      ArrayList<IMotion> motions) {
    this.type = type;
    this.name = name;
    this.pos = pos;
    this.dim = dim;
    this.color = color;
    this.motions = motions;
  }

  /**
   * Constructs a shape that includes a list of motions that is to be animated.
   */
  public Shape(IShape shape) {
    this.type = shape.getType();
    this.name = shape.getName();
    this.pos = shape.getPos();
    this.dim = shape.getDim();
    this.color = shape.getColor();
    this.motions = shape.getMotions();
  }

  public String getType() {
    return this.type;
  }

  @Override
  public IPosn getPos() {
    return this.pos;
  }

  @Override
  public IPosn getDim() {
    return this.dim;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public IColor getColor() {
    return this.color;
  }

  @Override
  public void setPos(IPosn s) {
    this.pos = s;
  }

  /**
   * returns a copy of this shape with the given posn.
   *
   * @param s the position to set the copy at
   */
  @Override
  public IShape newPos(IPosn s) {
    return new Shape(this.name, this.type, s, this.dim, this.color);
  }


  @Override
  public void setDim(IPosn s) {
    this.dim = s;
  }

  @Override
  public void setColor(IColor c) {
    this.color = c;
  }

  @Override
  public void setMotions(ArrayList<IMotion> m) {
    this.motions = m;
  }

  @Override
  public String toString() {
    String motionString = "";
    for (IMotion m : this.motions) {
      motionString += m.toString() + "\n";
    }
    return "shape" + " " + this.name + " " + this.type + "\n" + motionString;
  }

  @Override
  public void addMotion(IMotion m) {
    this.motions.add(m);
  }

  @Override
  public IShape renderShape(int timeStamp) {
    IMotion correct = null;
    for (IMotion m : this.motions) {
      if ((m.getStart() <= timeStamp) && (m.getEnd() >= timeStamp)) {
        correct = m;
        break;
      }
    }
    if (correct == null) {
      return this;
    }
    int interval = correct.getEnd() - correct.getStart();
    int time = timeStamp - correct.getStart();
    double ratio = (double) time / (double) interval;
    IShape start = new Shape(correct.getInitial());

    IShape change = new Shape(correct.getResult());
    IShape render = new Shape(start);

    render.setPos(change.getPos().change(start.getPos(), ratio)
        .add(start.getPos().getX(), start.getPos().getY()));

    render.setDim(change.getDim().change(start.getDim(), ratio)
        .add(start.getDim().getX(), start.getDim().getY()));

    render.setColor(change.getColor().change(change.getColor(), ratio).add(start.getColor()));

    return render;
  }

  public ArrayList<IMotion> getMotions() {
    return new ArrayList<>(this.motions);
  }

  @Override
  public IViewShape convert() {
    switch (this.type) {
      case "Rectangle":
      case "rectangle":
        return new ViewRect(this);
      case "Ellipse":
      case "ellipse":
      case "oval":
      case "Oval":
        return new ViewOval(this);
      default:
        throw new IllegalArgumentException("Invalid shape");
    }
  }

  @Override
  public int lastTick() {
    return motions.get(motions.size() - 1).getEnd();
  }

  @Override
  public ProviderShape customer() {
    switch (this.type) {
      case "Rectangle":
      case "rectangle":
        return new Rectangle(this);
      case "Ellipse":
      case "ellipse":
      case "oval":
      case "Oval":
        return new Ellipse(this);
      default:
        throw new IllegalArgumentException("Invalid shape");
    }
  }

  /**
   * Determines whether or not the given object is equal to this shape.
   *
   * @param o the object to be compared to this shape
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
    Shape shape = (Shape) o;
    return Objects.equals(pos, shape.pos)
        && Objects.equals(dim, shape.dim)
        && Objects.equals(color, shape.color)
        && Objects.equals(name, shape.name)
        && Objects.equals(motions, shape.motions)
        && Objects.equals(type, shape.type);
  }

  /**
   * Returns the hashcode of this shape.
   *
   * @return the hashcode of this shape
   */
  @Override
  public int hashCode() {
    return Objects.hash(pos, dim, color, name, motions);
  }
}

