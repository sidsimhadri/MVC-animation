package cs3500.animator.view;

import cs3500.animator.model.IShape;
import cs3500.animator.model.IMotion;

/**
 * Represents a shape in XML format.
 */
public class XMLShape {

  IShape shape;

  /**
   * Constructs a XMLShape.
   *
   * @param shape the shape to be converted.
   */
  public XMLShape(IShape shape) {
    this.shape = shape;
  }

  /**
   * Outputs this shape as a string in xml format.
   *
   * @param speed the speed at which to display the shape
   * @return a string representation of this shape in xml format
   */
  public String xmlShape(double speed) {
    StringBuilder motionString = new StringBuilder();
    for (IMotion m : this.shape.getMotions()) {
      motionString.append(new XMLMotion(m).xmlMotion(speed)).append("\n");
    }
    switch (this.shape.getType()) {
      case "Rectangle":
      case "rectangle":
        return
            "<rect x=" + "\"" + this.shape.getPos().getX() + "\"" +
                " y=" + "\"" + this.shape.getPos().getY() + "\"" +
                " width=" + "\"" + this.shape.getDim().getX() + "\"" +
                " height=" + "\"" + this.shape.getDim().getY() + "\"" +
                " fill=" + "\"" + this.shape.getColor().fancyString() + "\"" + ">" +
                motionString +
                "</rect>";
      case "Oval":
      case "Ellipse":
      case "oval":
      case "ellipse":
        return
            "<ellipse cx=" + "\"" + this.shape.getPos().getX() + "\"" +
                " cy=" + "\"" + this.shape.getPos().getY() + "\"" +
                " rx=" + "\"" + this.shape.getDim().getX() + "\"" +
                " ry=" + "\"" + this.shape.getDim().getY() + "\"" +
                " fill=" + "\"" + this.shape.getColor().fancyString() + "\"" + ">" +
                motionString +
                "</ellipse>";
      default:
        return "invalid shape";
    }
  }
}

