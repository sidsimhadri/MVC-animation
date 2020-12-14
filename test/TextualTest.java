import static org.junit.Assert.assertEquals;

import cs3500.animator.Controller;
import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.Color;
import cs3500.animator.model.IMotion;
import cs3500.animator.model.IShape;
import cs3500.animator.model.Motion;
import cs3500.animator.model.Posn;
import cs3500.animator.model.Shape;

import cs3500.animator.view.AnimationView;
import cs3500.animator.IController;
import cs3500.animator.view.TextualMotion;
import cs3500.animator.view.TextualShape;

import cs3500.animator.view.TextualView;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * Contains tests for the textualView.
 */
public class TextualTest {

  IShape rect1 = new Shape("Rectangle", "R", new Posn(5, 5), new Posn(10, 5),
      new Color(255, 255, 255), new ArrayList<IMotion>());
  IShape rect2 = new Shape("Rectangle", "R", new Posn(5, 20), new Posn(10, 5),
      new Color(255, 255, 255), new ArrayList<IMotion>());
  IShape triangle1 = new Shape("Triangle", "T", new Posn(30, 10), new Posn(20, 10),
      new Color(255, 255, 255), new ArrayList<IMotion>());
  IShape triangle2 = new Shape("Triangle", "T", new Posn(30, 20), new Posn(20, 5),
      new Color(255, 255, 255), new ArrayList<IMotion>());
  IShape oval1 = new Shape("Oval", "O", new Posn(50, 10), new Posn(10, 5),
      new Color(255, 255, 255), new ArrayList<IMotion>());
  IShape oval2 = new Shape("Oval", "O", new Posn(50, 5), new Posn(10, 5),
      new Color(255, 255, 255), new ArrayList<IMotion>());
  Motion motion1 = new Motion(5, 10, rect1, rect2);
  Motion motion2 = new Motion(5, 10, triangle1, triangle2);
  Motion motion3 = new Motion(25, 30, oval1, oval2);

  @Before
  public void setUp() {
    rect1.addMotion(motion1);
    triangle1.addMotion(motion2);
    oval1.addMotion(motion3);

  }

  @Test
  public void testMotion() {
    assertEquals(
        "motion R 2.5 5 5 10 5 255 255 255 5.0 5 20 10 5 255 255 255\n",
        new TextualMotion(motion1).render(2));

    assertEquals(
        "motion O 25.0 50 10 10 5 255 255 255 30.0 50 5 10 5 255 255 255\n",
        new TextualMotion(motion3).render(1));
  }

  @Test
  public void testShape() {
    assertEquals(
        "shape R Rectangle\n"
            + "motion R 0.25 5 5 10 5 255 255 255 0.5 5 20 10 5 255 255 255\n",
        new TextualShape(rect1).render(20));

    assertEquals(
        "shape O Oval\n"
            + "motion O 1.25 50 10 10 5 255 255 255 1.5 50 5 10 5 255 255 255\n",
        new TextualShape(oval1).render(20));
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testUnsupported() {
    AnimationView text = new TextualView();
    IController controller = new Controller(text, new AnimatorModel());
    text.setPaused(false);
    text.addListener(controller);
    text.addChange(controller);
    text.setTickSpeed(1.0);
    text.getTick();
    text.reDo();
    text.setLooping(false);
    text.setLastTick(1);
    text.getLooping();
  }

}
