package cs3500.animator;

import cs3500.animator.provider.model.AbstractAnimation;
import cs3500.animator.model.AnimatorModel.Builder;
import cs3500.animator.model.IAnimatorModel;
import cs3500.animator.provider.view.AnimationTextView;
import cs3500.animator.util.AnimationReader;
import cs3500.animator.provider.view.AnimationInteractiveVisualView;
import cs3500.animator.view.AnimationView;
import cs3500.animator.view.ViewFactory;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

//-providerText uses the provider textual view

/**
 * Represents the main class of this animation where it all begins.
 */
public class Excellence {

  /**
   * Based on user input creates an animation.
   *
   * @param args the user specified input of what they want
   * @throws IOException throws an exception if an invalid input is made
   */
  public static void main(String[] args) throws IOException {
    AnimationView view = null;
    IAnimatorModel model = null;
    Boolean provider = false;
    Boolean text = false;
    int speed = 1;
    String out = "System.out";
    if (args.length >= 4) {
      for (int i = 0; i < args.length; i++) {  //counted for loop
        if (args[i].equals("-in")) {
          try {
            model =
                new AnimationReader().parseFile(new FileReader(args[i
                        + 1]),
                    new Builder());
          } catch (IndexOutOfBoundsException e) {
            throw
                new IndexOutOfBoundsException("-in must be followed by an input file");
          }
        } else if (args[i].equals("-out")) {
          try {
            out = args[i + 1];
          } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("-out must be followed by an output file");
          }
        } else if (args[i].equals("-view")) {
          try {
            if (args[i + 1].compareToIgnoreCase("provider") == 0) {
              provider = true;
            } else if (args[i + 1].compareToIgnoreCase("providerText") == 0) {
              text = true;
            } else {
              view = new ViewFactory().create(args[i + 1]);
            }
          } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("view must be followed by an view type");
          }
        } else if (args[i].equals("-speed")) {
          try {
            speed = Integer.valueOf(args[i + 1]);
          } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("speed must be followed by a speed");
          }
        }
      }
      if (provider) {
        new ProviderController(new AnimationInteractiveVisualView(speed,
            new AbstractAnimation<>(model))).start();

      } else if (text) {
        if (out.compareTo("out") == 0 || out.compareTo("System.out") == 0) {
          new AnimationTextView(speed, new AbstractAnimation<>(model), System.out).render();
        } else {
          new AnimationTextView(speed, new AbstractAnimation<>(model), new PrintStream(out))
              .render();
        }
      } else {

        view.setShapes(model.getShapes());

        try {
          view.setX(model.getX());
          view.setY(model.getY());
          view.setTopX(model.getTopX());
          view.setTopY(model.getTopY());
          view.setTickSpeed(speed);
          view.setLastTick(model.lastTick());
        } catch (UnsupportedOperationException e) {
          //empty catch block
        }

        new Controller(view, model).goo(speed, out);
      }
    } else {
      throw new IllegalArgumentException("Not enough inputs");
    }
  }
}