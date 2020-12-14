package cs3500.animator.view;

import cs3500.animator.model.IMotion;

/**
 * Represents a motion in XML format.
 */
public class XMLMotion {

  IMotion motion;

  /**
   * Constructs a XMLMotion.
   *
   * @param motion the motion to be converted.
   */
  public XMLMotion(IMotion motion) {
    this.motion = motion;
  }

  /**
   * Outputs the xml representation of this motion.
   *
   * @param speed the speed at which to display the motion
   * @return a string representation of the motion in xml format
   */
  public String xmlMotion(double speed) {
    switch (this.motion.getInitial().getType()) {
      case "Rectangle":
      case "rectangle":
        return
            "<animate attributeName=" + "\"" + "x" + "\"" +
                " attributeType=" + "\"" + "XML" + "\"" +
                " begin=" + "\"" + (this.motion.getStart() / speed) + "s" + "\"" +
                " dur=" + "\"" + ((this.motion.getEnd() - this.motion.getStart()) / speed) + "s"
                + "\"" +
                " fill=" + "\"" + "freeze" + "\"" +
                " from=" + "\"" + this.motion.getInitial().getPos().getX() + "\"" +
                " to=" + "\"" + this.motion.getResult().getPos().getX() + "\"" + "/>" +
                "<animate attributeName=" + "\"" + "y" + "\"" +
                " attributeType=" + "\"" + "XML" + "\"" +
                " begin=" + "\"" + (this.motion.getStart() / speed) + "s" + "\"" +
                " dur=" + "\"" + ((this.motion.getEnd() - this.motion.getStart()) / speed) + "s"
                + "\"" +
                " fill=" + "\"" + "freeze" + "\"" +
                " from=" + "\"" + this.motion.getInitial().getPos().getY() + "\"" +
                " to=" + "\"" + this.motion.getResult().getPos().getY() + "\"" + "/>" +
                "<animate attributeName=" + "\"" + "width" + "\"" +
                " attributeType=" + "\"" + "XML" + "\"" +
                " begin=" + "\"" + (this.motion.getStart() / speed) + "s" + "\"" +
                " dur=" + "\"" + ((this.motion.getEnd() - this.motion.getStart()) / speed) + "s"
                + "\"" +
                " fill=" + "\"" + "freeze" + "\"" +
                " from=" + "\"" + this.motion.getInitial().getDim().getX() + "\"" +
                " to=" + "\"" + this.motion.getResult().getDim().getX() + "\"" + "/>" +
                "<animate attributeName=" + "\"" + "height" + "\"" +
                " attributeType=" + "\"" + "XML" + "\"" +
                " begin=" + "\"" + (this.motion.getStart() / speed) + "s" + "\"" +
                " dur=" + "\"" + ((this.motion.getEnd() - this.motion.getStart()) / speed) + "s"
                + "\"" +
                " fill=" + "\"" + "freeze" + "\"" +
                " from=" + "\"" + this.motion.getInitial().getDim().getY() + "\"" +
                " to=" + "\"" + this.motion.getResult().getDim().getY() + "\"" + "/>" +
                "<animate attributeName=" + "\"" + "fill" + "\"" +
                " attributeType=" + "\"" + "XML" + "\"" +
                " begin=" + "\"" + (this.motion.getStart() / speed) + "s" + "\"" +
                " dur=" + "\"" + ((this.motion.getEnd() - this.motion.getStart()) / speed) + "s"
                + "\"" +
                " fill=" + "\"" + "freeze" + "\"" +
                " from=" + "\"" + this.motion.getInitial().getColor().fancyString() + "\"" +
                " to=" + "\"" + this.motion.getResult().getColor().fancyString() + "\"" + "/>";
      case "Oval":
      case "Ellipse":
      case "oval":
      case "ellipse":
        return
            "<animate attributeName=" + "\"" + "cx" + "\"" +
                " attributeType=" + "\"" + "XML" + "\"" +
                " begin=" + "\"" + (this.motion.getStart() / speed) + "s" + "\"" +
                " dur=" + "\"" + ((this.motion.getEnd() - this.motion.getStart()) / speed) + "s"
                + "\"" +
                " fill=" + "\"" + "freeze" + "\"" +
                " from=" + "\"" + this.motion.getInitial().getPos().getX() + "\"" +
                " to=" + "\"" + this.motion.getResult().getPos().getX() + "\"" + "/>" +
                "<animate attributeName=" + "\"" + "cy" + "\"" +
                " attributeType=" + "\"" + "XML" + "\"" +
                " begin=" + "\"" + (this.motion.getStart() / speed) + "s" + "\"" +
                " dur=" + "\"" + ((this.motion.getEnd() - this.motion.getStart()) / speed) + "s"
                + "\"" +
                " fill=" + "\"" + "freeze" + "\"" +
                " from=" + "\"" + this.motion.getInitial().getPos().getY() + "\"" +
                " to=" + "\"" + this.motion.getResult().getPos().getY() + "\"" + "/>" +
                "<animate attributeName=" + "\"" + "rx" + "\"" +
                " attributeType=" + "\"" + "XML" + "\"" +
                " begin=" + "\"" + (this.motion.getStart() / speed) + "s" + "\"" +
                " dur=" + "\"" + ((this.motion.getEnd() - this.motion.getStart()) / speed) + "s"
                + "\"" +
                " fill=" + "\"" + "freeze" + "\"" +
                " from=" + "\"" + this.motion.getInitial().getDim().getX() + "\"" +
                " to=" + "\"" + this.motion.getResult().getDim().getX() + "\"" + "/>" +
                "<animate attributeName=" + "\"" + "ry" + "\"" +
                " attributeType=" + "\"" + "XML" + "\"" +
                " begin=" + "\"" + (this.motion.getStart() / speed) + "s" + "\"" +
                " dur=" + "\"" + ((this.motion.getEnd() - this.motion.getStart()) / speed) + "s"
                + "\"" +
                " fill=" + "\"" + "freeze" + "\"" +
                " from=" + "\"" + this.motion.getInitial().getDim().getY() + "\"" +
                " to=" + "\"" + this.motion.getResult().getDim().getY() + "\"" + "/>" +
                "<animate attributeName=" + "\"" + "fill" + "\"" +
                " attributeType=" + "\"" + "XML" + "\"" +
                " begin=" + "\"" + (this.motion.getStart() / speed) + "s" + "\"" +
                " dur=" + "\"" + ((this.motion.getEnd() - this.motion.getStart()) / speed) + "s"
                + "\"" +
                " fill=" + "\"" + "freeze" + "\"" +
                " from=" + "\"" + this.motion.getInitial().getColor().fancyString() + "\"" +
                " to=" + "\"" + this.motion.getResult().getColor().fancyString() + "\"" + "/>";
      default:
        return "invalid shape";
    }
  }
}