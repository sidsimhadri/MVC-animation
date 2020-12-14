package cs3500.animator.provider.view;

import cs3500.animator.provider.model.AbstractAnimation;
import cs3500.animator.model.Canvas;
import cs3500.animator.provider.model.ProviderMotion;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * concrete class for AnimationView. This class converts the Animation Model into a representation
 * of a text file.It implements the AnimationView interface. Render to the following file format:
 * canvas 200 70 360 360 shape R rectangle motion R 0.20 200 200 50 100 255 0 0 2.00 200 200 50 100
 * 255 0 0 motion R 2.00 200 200 50 100 255 0 0 10.00 300 300 50 100 255 0 0 motion R 10.00 300 300
 * 50 100 255 0 0 10.20 300 300 50 100 255 0 0 motion R 10.20 300 300 50 100 255 0 0 14.00 300 300
 * 25 100 255 0 0 motion R 14.00 300 300 25 100 255 0 0 20.00 200 200 25 100 255 0 0 shape C ellipse
 * motion C 1.20 440 70 120 60 0 0 255 4.00 440 70 120 60 0 0 255 motion C 4.00 440 70 120 60 0 0
 * 255 10.00 440 250 120 60 0 0 255 motion C 10.00 440 250 120 60 0 0 255 14.00 440 370 120 60 0 170
 * 85 motion C 14.00 440 370 120 60 0 170 85 16.00 440 370 120 60 0 255 0 motion C 16.00 440 370 120
 * 60 0 255 0 20.00 440 370 120 60 0 255 0
 */
public class AnimationTextView implements ProviderAnimationView {

  private final double speed;
  private final AbstractAnimation<ProviderMotion> animation;
  private final PrintStream out;

  /**
   * Constructor, set necessary variable.
   *
   * @param speed     speed value
   * @param animation animation reference
   * @param out       out stream
   */
  public AnimationTextView(double speed,
      AbstractAnimation<ProviderMotion> animation, PrintStream out) {
    if (speed <= 0 || animation == null || out == null) {
      throw new IllegalArgumentException();
    }
    this.speed = speed;
    this.animation = animation;
    this.out = out;
  }

  @Override
  public void render() throws IOException {
    Canvas canvas = animation.getCanvas();
    out.printf("canvas %d %d %d %d\n", canvas.getX(), canvas.getY(), canvas.getWidth(),
        canvas.getHeight());
    Map<String, List<ProviderMotion>> map = animation.getAnimate();
    for (Entry<String, List<ProviderMotion>> entry : map.entrySet()) {
      String name = entry.getKey();
      List<ProviderMotion> providerMotions = entry.getValue();
      out.printf("shape %s %s\n", name, animation.getShapeType(name).toString().toLowerCase());
      for (ProviderMotion providerMotion : providerMotions) {
        out.printf("motion %s %.2f %s %.2f %s\n", name, providerMotion.getStartTick() / speed,
            providerMotion.getStartShape(), providerMotion.getEndTick() / speed,
            providerMotion.getEndShape());
      }
    }

  }
}
