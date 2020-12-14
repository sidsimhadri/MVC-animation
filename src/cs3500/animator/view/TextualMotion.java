package cs3500.animator.view;

import cs3500.animator.model.IMotion;

/**
 * Represents a motion in text.
 */
public class TextualMotion {

  IMotion motion;

  /**
   * Constructs a Textual motion.
   *
   * @param m the motion to be converted
   */
  public TextualMotion(IMotion m) {
    this.motion = m;
  }

  /**
   * Outputs this motion into a string based off the the given speed.
   *
   * @param speed the speed to do the motion at
   * @return a string representation of the motion
   */
  public String render(double speed) {
    return "motion " + this.motion.getInitial().getName() + " " + this.motion.getStart() / speed
        + " " + this.motion
        .getInitial().getPos().toString() + " " + this.motion
        .getInitial().getDim().toString() + " " + this.motion
        .getInitial().getColor()
        .toString() + " " + this.motion.getEnd() / speed + " " + this.motion.getResult().getPos()
        .toString()
        + " " + this.motion.getResult().getDim().toString() + " " + this.motion.getResult()
        .getColor()
        .toString() + "\n";
  }
}
