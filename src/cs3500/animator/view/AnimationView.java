package cs3500.animator.view;


import cs3500.animator.model.IShape;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;

/**
 * Represents a view for this animation which is what the user sees.
 */
public interface AnimationView {

  /**
   * Sets the shapes to the given shapes.
   *
   * @param shapes the shapes to set it to
   */
  void setShapes(ArrayList<IShape> shapes);

  /**
   * Renders a view based on a given specified speed and outfile.
   *
   * @param speed   the speed the animation should happen at
   * @param outfile the outfile the information should go to
   * @throws IOException throws an exception
   */
  void render(double speed, String outfile) throws IOException;

  /**
   * Updates the view to the current state.
   */
  void refresh();


  /**
   * Draws the shapes at the given tick.
   *
   * @param time the tick at which to draw the shapes
   */
  void drawShapes(int time);

  /**
   * Writes the given string to the given file name.
   *
   * @param output  the string to put in the file
   * @param outfile the name of the file to create
   * @throws IOException throws an exception
   */
  void writeOutUsingBufferedWriter(String output, String outfile) throws IOException;

  /**
   * Converts this model into XML Format.
   *
   * @param speed the speed at which the animation should go
   * @return a string representation of the model in XML format
   */
  String xmlModel(double speed);

  /**
   * Sets this views pause state to b.
   *
   * @param b the pause state to set
   */
  void setPaused(Boolean b);

  /**
   * Returns the pause state of this view.
   *
   * @return the pause state of this view
   */
  boolean getPaused();

  /**
   * Returns the play button for this view.
   *
   * @return the play button for this view
   */
  JButton getPlay();

  /**
   * Adds the given ActionListener to the interactive components of this view.
   *
   * @param listener the listen to add
   */
  void addListener(ActionListener listener);

  /**
   * Adds the given ChangeListener to the interactive components of this view.
   *
   * @param listener the listen to add
   */
  void addChange(ChangeListener listener);


  /**
   * Sets the tick speed to the given value.
   *
   * @param value the value to the set tick speed to
   */
  void setTickSpeed(double value);

  /**
   * Returns the loop button.
   *
   * @return the loop button.
   */
  JButton getLooping();

  /**
   * Restarts the animation.
   */
  void reDo();

  /**
   * Gets the current tick of the view.
   *
   * @return the current tick of the view
   */
  int getTick();


  /**
   * Sets the x size of the frame.
   *
   * @param x size to set
   */
  void setX(int x);

  /**
   * Sets the y size of the frame.
   *
   * @param y size to set
   */
  void setY(int y);

  /**
   * Sets the top x of the frame.
   *
   * @param x top to set
   */
  void setTopX(int x);

  /**
   * Sets the top y of the frame.
   *
   * @param y top to set
   */
  void setTopY(int y);

  /**
   * Sets the loop status of the view.
   *
   * @param b wether or not the view should loop
   */
  void setLooping(boolean b);

  /**
   * Sets the final tick for the model being animated.
   *
   * @param t the last tick for the model being animated
   */
  void setLastTick(int t);
}
