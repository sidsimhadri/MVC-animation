package cs3500.animator.view;

import java.awt.Graphics;

/**
 * Represents a shape from the model but in compatible view format.
 */
public interface IViewShape {

  /**
   * Renders an IViewShape based on the given graphics.
   *
   * @param g the graphics to use
   */
  void render(Graphics g);

  /**
   * Interpolates the IViewShape based on the give timestamp.
   *
   * @param timestamp the time stamp to use to interpolate
   * @return an interpolated IViewShape based on the given timestamp
   */
  IViewShape interpolate(int timestamp);
}
