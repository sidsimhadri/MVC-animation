package cs3500.animator.model;

/**
 * Define the size and position of the animation screen.
 */
public class Canvas {

  private final int x;
  private final int y;
  private final int width;
  private final int height;

  /**
   * Constructor.
   *
   * @param x      x
   * @param y      y
   * @param width  width
   * @param height height
   */
  public Canvas(int x, int y, int width, int height) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException();
    }
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  /**
   * getter for x.
   *
   * @return x
   */
  public int getX() {
    return x;
  }

  /**
   * getter for y.
   *
   * @return y
   */
  public int getY() {
    return y;
  }

  /**
   * getter for width.
   *
   * @return width
   */
  public int getWidth() {
    return width;
  }

  /**
   * getter for height.
   *
   * @return height
   */
  public int getHeight() {
    return height;
  }
}
