import cs3500.animator.model.Color;
import cs3500.animator.model.IMotion;
import cs3500.animator.model.IShape;
import cs3500.animator.model.Motion;
import cs3500.animator.model.Posn;
import cs3500.animator.model.Shape;
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Contains tests for the motion class.
 */
public class TestMotion {


  IShape rect1 = new Shape("Rectangle", "R", new Posn(5, 5), new Posn(10, 5),
      new Color(255, 255, 255), new ArrayList<IMotion>());
  IShape rect2 = new Shape("Rectangle", "R", new Posn(5, 20), new Posn(10, 5),
      new Color(255, 255, 255), new ArrayList<IMotion>());

  IShape triangle1 = new Shape("Triangle", "T", new Posn(30, 10),
      new Posn(20, 10),
      new Color(255, 255, 255), new ArrayList<IMotion>());
  IShape triangle2 = new Shape("Triangle", "T", new Posn(30, 20),
      new Posn(20, 5),
      new Color(255, 255, 255), new ArrayList<IMotion>());

  IShape oval1 = new Shape("Oval", "O", new Posn(50, 10), new Posn(10, 5),
      new Color(255, 255, 255), new ArrayList<IMotion>());
  IShape oval2 = new Shape("Oval", "O", new Posn(50, 5), new Posn(10, 5),
      new Color(255, 255, 255), new ArrayList<IMotion>());
  IShape oval15 = new Shape("Oval", "O", new Posn(50, 8), new Posn(10, 5),
      new Color(255, 255, 255),
      new ArrayList<IMotion>());

  Motion motion1 = new Motion(5, 10, rect1, rect2);
  Motion motion2 = new Motion(5, 10, triangle1, triangle2);
  Motion motion3 = new Motion(25, 30, oval1, oval2);


  @Test
  public void testToString() {
    assertEquals("motion R 5 5 5 10 5 255 255 255 10 5 20 10 5 255 255 255",
        motion1.toString());
    assertEquals("motion T 5 30 10 20 10 255 255 255 10 30 20 20 5 255 255 255",
        motion2.toString());
    assertEquals("motion O 25 50 10 10 5 255 255 255 30 50 5 10 5 255 255 255",
        motion3.toString());
  }

  @Test
  public void testGetStart() {
    assertEquals(5, motion1.getStart());
    assertEquals(5, motion2.getStart());
    assertEquals(25, motion3.getStart());
  }

  @Test
  public void testGetEnd() {
    assertEquals(10, motion1.getEnd());
    assertEquals(10, motion2.getEnd());
    assertEquals(30, motion3.getEnd());

  }

  @Test
  public void testGetInitial() {
    assertEquals(rect1, motion1.getInitial());
    assertEquals(triangle1, motion2.getInitial());
    assertEquals(oval1, motion3.getInitial());
  }

  @Test
  public void testGetResult() {
    assertEquals(rect2, motion1.getResult());
    assertEquals(triangle2, motion2.getResult());
    assertEquals(oval2, motion3.getResult());
  }
}
