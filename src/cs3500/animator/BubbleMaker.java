package cs3500.animator;

import cs3500.animator.util.BubbleSortCreator;
import java.io.IOException;

/**
 * Class to run the bubblesortCreator.
 */
public class BubbleMaker {

  /**
   * Runs the bubblesortcreator.
   *
   * @param args running args
   * @throws IOException if inputs aren't valid
   */
  public static void main(String[] args) throws IOException {
    BubbleSortCreator bubble = new BubbleSortCreator();
    int num = 0;
    int x = 0;
    int y = 0;
    int height = 0;
    int width = 0;
    if (args.length >= 4) {
      for (int i = 0; i < args.length; i++) {  //counted for loop
        if (args[i].equals("-num")) {
          try {
            num = Integer.parseInt(args[i + 1]);
          } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("-num must be followed by an input");
          }
        }
        if (args[i].equals("-x")) {
          try {
            x = Integer.parseInt(args[i + 1]);
          } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("-x must be followed by an input");
          }

        }
        if (args[i].equals("-y")) {
          try {
            y = Integer.parseInt(args[i + 1]);
          } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("-y must be followed by an input");
          }
        }
        if (args[i].equals("-height")) {
          try {
            height = Integer.parseInt(args[i + 1]);
          } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("-height must be followed by an input");
          }
        }
        if (args[i].equals("-width")) {
          try {
            width = Integer.parseInt(args[i + 1]);
          } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("-width must be followed by an input");
          }
        }
      }
      if (num != 0 && height != 0 && width != 0) {
        bubble.solve(num, x, y, height, width);
        bubble.bubbleSort();
        bubble.make();
        bubble.write();

      } else {
        throw new IllegalArgumentException("only x and y can be 0");
      }
    }
  }
}
