
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
import cs3500.animator.view.SVGAnimationView;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import cs3500.animator.view.XMLMotion;
import cs3500.animator.view.XMLShape;


import static org.junit.Assert.assertEquals;

/**
 * Tests for the AnimatorModel class of the animation.
 */
public class SVGTest {

  IShape rect1 = new Shape("Rectangle", "R", new Posn(5, 5), new Posn(10, 5),
      new Color(255, 255, 255), new ArrayList<IMotion>());
  IShape rect2 = new Shape("Rectangle", "R", new Posn(5, 20), new Posn(10, 5),
      new Color(255, 255, 255), new ArrayList<IMotion>());

  IShape triangle1 = new Shape("Triangle", "T", new Posn(30, 10),
      new Posn(20, 10),
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
  AnimationView svg = new SVGAnimationView();

  @Before
  public void setUp() {
    rect1.addMotion(motion1);
    triangle1.addMotion(motion2);
    oval1.addMotion(motion3);

  }

  @Test
  public void testMotion() {
    assertEquals(
        "<animate attributeName=\"x\" attributeType=\"XML\" begin=\"2.5s\""
            + " dur=\"2.5s\" fill=\"freeze\" from=\"5\" to=\"5\"/><animate attributeName=\"y\" "
            + "attributeType=\"XML\" begin=\"2.5s\" dur=\"2.5s\" fill=\"freeze\" from=\"5\" "
            + "to=\"20\"/><animate attributeName=\"width\" attributeType=\"XML\" begin=\"2.5s\" "
            + "dur=\"2.5s\" fill=\"freeze\" from=\"10\" to=\"10\"/><animate attributeName=\"height"
            + "\" attributeType=\"XML\" begin=\"2.5s\" dur=\"2.5s\" fill=\"freeze\" from=\"5\" "
            + "to=\"5\"/><animate attributeName=\"fill\" attributeType=\"XML\" begin=\"2.5s\" "
            + "dur=\"2.5s\" fill=\"freeze\" from=\"rgb(255,255,255)\" to=\"rgb(255,255,255)\"/>",
        new XMLMotion(motion1).xmlMotion(2));

    assertEquals(
        "<animate attributeName=\"cx\" attributeType=\"XML\" begin=\"25.0s\" "
            + "dur=\"5.0s\" fill=\"freeze\" from=\"50\" to=\"50\"/><animate attributeName=\"cy"
            + "\" attributeType=\"XML\" begin=\"25.0s\" dur=\"5.0s\" fill=\"freeze\" from=\"10\" "
            + "to=\"5\"/><animate attributeName=\"rx\" attributeType=\"XML\" begin=\"25.0s\" dur=\""
            + "5.0s\" fill=\"freeze\" from=\"10\" to=\"10\"/><animate attributeName=\"ry\""
            + " attributeType=\"XML\" begin=\"25.0s\" dur=\"5.0s\" fill=\"freeze\" from=\"5\" "
            + "to=\"5\"/><animate attributeName=\"fill\" attributeType=\"XML\" begin=\"25.0s\" "
            + "dur=\"5.0s\" fill=\"freeze\" from=\"rgb(255,255,255)\" to=\"rgb(255,255,255)\"/>",
        new XMLMotion(motion3).xmlMotion(1));
  }

  @Test
  public void testShape() {
    assertEquals(
        "<rect x=\"5\" y=\"5\" width=\"10\" height=\"5\" fill=\"rgb(255,255,255)\">"
            + "<animate attributeName=\"x\" attributeType=\"XML\" begin=\"0.25s\" dur=\"0.25s\""
            + " fill=\"freeze\" from=\"5\" to=\"5\"/><animate attributeName=\"y\" "
            + "attributeType=\"XML\" begin=\"0.25s\" dur=\"0.25s\" fill=\"freeze\" from=\"5\""
            + " to=\"20\"/><animate attributeName=\"width\" attributeType=\"XML\" begin=\"0.25s\""
            + " dur=\"0.25s\" fill=\"freeze\" from=\"10\" to=\"10\"/><animate attributeName=\"he"
            + "ight\" attributeType=\"XML\" begin=\"0.25s\" dur=\"0.25s\" fill=\"freeze\" from"
            + "=\"5\" to=\"5\"/><animate attributeName=\"fill\" attributeType=\"XML\" begin=\"0.25"
            + "s\" dur=\"0.25s\" fill=\"freeze\" from=\"rgb(255,255,255)\" to=\"rgb(255,255,"
            + "255)\"/>\n"
            + "</rect>",
        new XMLShape(rect1).xmlShape(20));

    assertEquals(
        "<ellipse cx=\"50\" cy=\"10\" rx=\"10\" ry=\"5\" fill=\"rgb(255,255,255)\""
            + "><animate attributeName=\"cx\" attributeType=\"XML\" begin=\"1.25s\" dur=\""
            + "0.25s\" fill=\"freeze\" from=\"50\" to=\"50\"/><animate attributeName=\"cy\" a"
            + "ttributeType=\"XML\" begin=\"1.25s\" dur=\"0.25s\" fill=\"freeze\" from=\"1"
            + "0\" to=\"5\"/><animate attributeName=\"rx\" attributeType=\"XML\" begin=\""
            + "1.25s\" dur=\"0.25s\" fill=\"freeze\" from=\"10\" to=\"10\"/><animate attributeName="
            + "\"ry\" attributeType=\"XML\" begin=\"1.25s\" dur=\"0.25s\" fill=\"freeze\" from=\"5"
            + "\" to=\"5\"/><animate attributeName=\"fill\" attributeType=\"XML\" begin=\"1.25s\""
            + " dur=\"0.25s\" fill=\"freeze\" from=\"rgb(255,255,255)\" to=\"rgb(255,255,255)\"/>\n"
            + "</ellipse>",
        new XMLShape(oval1).xmlShape(20));
  }


  @Test(expected = UnsupportedOperationException.class)
  public void testUnsupported() throws IOException {

    IController controller = new Controller(svg, new AnimatorModel());
    svg.refresh();
    svg.setPaused(false);
    svg.addListener(controller);
    svg.addChange(controller);
    svg.setTickSpeed(1.0);
    svg.getTick();
    svg.reDo();
    svg.setLooping(false);
    svg.setLastTick(1);
    svg.getLooping();


  }


}
