package cs3500.animator.view;

import cs3500.animator.model.IShape;
import cs3500.animator.model.IMotion;

/**
 * Represents a shape in text.
 */
public class TextualShape {

  IShape shape;

  /**
   * Constructs a Textual shape.
   *
   * @param s the shape to be converted
   */
  public TextualShape(IShape s) {
    this.shape = s;
  }

  /**
   * Outputs this shape as a string based off of the given speed.
   *
   * @param speed the speed at which to render the shape
   * @return a string representation of the shape
   */
  public String render(double speed) {
    String motionString = "";
    for (IMotion m : this.shape.getMotions()) {
      motionString += new TextualMotion(m).render(speed);
    }
    return "shape" + " " + this.shape.getName() + " " + this.shape.getType() + "\n" + motionString;
  }
}
