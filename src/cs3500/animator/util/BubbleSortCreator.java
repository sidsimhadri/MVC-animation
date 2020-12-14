package cs3500.animator.util;

import cs3500.animator.model.Color;
import cs3500.animator.model.IShape;
import cs3500.animator.model.Motion;
import cs3500.animator.model.Posn;
import cs3500.animator.model.Shape;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Contains methods to create a runnable motion file to represent BubbleSort.
 */
public class BubbleSortCreator {

  ArrayList<IShape> shapes = new ArrayList<>();
  private int height;
  private int x;
  private int width;
  private int y;


  /**
   * Initializes the shapes.
   *
   * @param numRects number of rects to be sorted
   * @param x        top X
   * @param y        top Y
   * @param height   frame height
   * @param width    frame width
   */
  public void solve(int numRects, int x, int y, int height, int width) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    int thick = width / numRects;
    int spot = 0;
    Random rand = new Random();
    for (int i = 0; i < numRects; i++) {

      int h = rand.nextInt(height - (height / numRects)) + (height / numRects);
      shapes.add(new Shape("R" + i, "rectangle", new Posn(spot, 0), new Posn(thick, h),
          new Color(180, 226, 215)));
      shapes.get(i).addMotion(new Motion(1, 2, shapes.get(i), shapes.get(i)));
      spot += thick;
    }
  }

  /**
   * Adds all the necessary motions to visualize bubbleSort.
   */
  public void bubbleSort() {
    int n = shapes.size();
    int t = 3;

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (shapes.get(j).getDim().getY() > shapes.get(j + 1).getDim().getY()) {
          IShape left = new Shape(shapes.get(j));
          IShape right = new Shape(shapes.get(j + 1));
          shapes.get(j)
              .addMotion(new Motion(t, t + 5, left.renderShape(t - 1),
                  left.newPos(right.renderShape(t - 1).getPos())));

          shapes.get(j + 1).addMotion(new Motion(t, t + 5, right.renderShape(t - 1),
              right.newPos(left.renderShape(t - 1).getPos())));

          shapes.get(j).setPos(right.renderShape(t).getPos());
          shapes.get(j + 1).setPos(left.renderShape(t).getPos());
          for (int z = 0; z < shapes.size(); z++) {
            if (z != j && z != j + 1) {
              shapes.get(z).addMotion(new Motion(t, t + 5, shapes.get(z).renderShape(t - 1),
                  shapes.get(z).renderShape(t - 1)));
            }
          }
          Collections.swap(this.shapes, j, j + 1);
          StringBuilder result = new StringBuilder();

          for (IShape s : shapes) {
            result.append(s.getDim().getY() + "  ");
          }
          System.out.print(result + "\n");

          t += 5;


        }

      }
    }
  }

  /**
   * Renders a runnable string from the created animation model.
   *
   * @return the runnable string.
   * @throws IOException throws an exception
   */
  public String make() throws IOException {
    StringBuilder result = new StringBuilder();
    result.append("canvas " + this.x + " " + this.y + " " + this.width + " " + this.height + "\n");
    for (IShape s : this.shapes) {
      result.append(s.toString());
    }
    return new ShapeString(result.toString()).toTop();
  }

  /**
   * Writes the  to the given file name.
   *
   * @throws IOException throws an exception
   */
  public void write() throws IOException {
    BufferedWriter writer = new BufferedWriter(
        new FileWriter("GenBubbleSort.txt"));
    writer.write(this.make());
    writer.flush();
    writer.close();
  }

}
