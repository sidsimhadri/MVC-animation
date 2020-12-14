package cs3500.animator;

import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.event.ChangeListener;

/**
 * Represents a Controller of this Animation, allowing the model and view to work together.
 */
public interface IController extends ActionListener, ChangeListener {

  /**
   * Renders an Animation based off of the given speed and outfile.
   *
   * @param speed   the speed at which the animation should go
   * @param outfile the outfile the output should go to
   * @throws IOException throws an exception
   */
  void goo(double speed, String outfile) throws IOException;
}
