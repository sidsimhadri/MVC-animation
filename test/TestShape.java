import cs3500.animator.model.Color;
import cs3500.animator.model.IMotion;
import cs3500.animator.model.IShape;
import cs3500.animator.model.Motion;
import cs3500.animator.model.Posn;
import cs3500.animator.model.Shape;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Tests for the Shape class of the animation.
 */
public class TestShape {

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
  IShape oval15 = new Shape("Oval", "O", new Posn(50, 8), new Posn(10, 5), new Color(255, 255, 255),
      new ArrayList<IMotion>());

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
  public void testGetPos() {
    assertEquals(new Posn(5, 5), rect1.getPos());
    assertEquals(new Posn(30, 10), triangle1.getPos());
    assertEquals(new Posn(50, 10), oval1.getPos());
  }

  @Test
  public void testGetDim() {
    assertEquals(new Posn(10, 5), rect1.getDim());
    assertEquals(new Posn(20, 10), triangle1.getDim());
    assertEquals(new Posn(10, 5), oval1.getDim());
  }

  @Test
  public void testGetName() {
    assertEquals("R", rect1.getName());
    assertEquals("T", triangle1.getName());
    assertEquals("O", oval1.getName());
  }

  @Test
  public void testGetColor() {
    assertEquals(new Color(255, 255, 255), rect1.getColor());
    assertEquals(new Color(255, 255, 255), triangle1.getColor());
    assertEquals(new Color(255, 255, 255), oval1.getColor());
  }

  @Test
  public void testGetMotions() {
    assertEquals(new ArrayList<Motion>(Collections.singleton(motion1)), rect1.getMotions());
    assertEquals(new ArrayList<Motion>(Collections.singleton(motion2)),
        triangle1.getMotions());
    assertEquals(new ArrayList<Motion>(Collections.singleton(motion3)), oval1.getMotions());
  }

  @Test
  public void testSetPos() {
    assertEquals(new Posn(5, 5), rect1.getPos());
    rect1.setPos(new Posn(10, 12));
    assertEquals(new Posn(10, 12), rect1.getPos());
    assertEquals(new Posn(30, 10), triangle1.getPos());
    triangle1.setPos(new Posn(10, 12));
    assertEquals(new Posn(10, 12), triangle1.getPos());
    assertEquals(new Posn(50, 10), oval1.getPos());
    oval1.setPos(new Posn(10, 12));
    assertEquals(new Posn(10, 12), oval1.getPos());
  }

  @Test
  public void testSetDim() {
    assertEquals(new Posn(10, 5), rect1.getDim());
    rect1.setDim(new Posn(5, 11));
    assertEquals(new Posn(5, 11), rect1.getDim());
    assertEquals(new Posn(20, 10), triangle1.getDim());
    triangle1.setDim(new Posn(5, 11));
    assertEquals(new Posn(5, 11), triangle1.getDim());
    assertEquals(new Posn(10, 5), oval1.getDim());
    oval1.setDim(new Posn(5, 11));
    assertEquals(new Posn(5, 11), oval1.getDim());
  }

  @Test
  public void testSetColor() {
    assertEquals(new Color(255, 255, 255), rect1.getColor());
    rect1.setColor(new Color(225, 179, 224));
    assertEquals(new Color(225, 179, 224), rect1.getColor());
    assertEquals(new Color(255, 255, 255), triangle1.getColor());
    triangle1.setColor(new Color(225, 179, 224));
    assertEquals(new Color(225, 179, 224), triangle1.getColor());
    assertEquals(new Color(255, 255, 255), oval1.getColor());
    oval1.setColor(new Color(225, 179, 224));
    assertEquals(new Color(225, 179, 224), oval1.getColor());
  }

  @Test
  public void testSetMotions() {
    assertEquals(new ArrayList<Motion>(Collections.singleton(motion1)),
        rect1.getMotions());
    rect1.setMotions(new ArrayList<IMotion>(Collections.singleton(motion2)));
    assertEquals(new ArrayList<Motion>(Collections.singleton(motion2)),
        rect1.getMotions());
    assertEquals(new ArrayList<Motion>(Collections.singleton(motion2)),
        triangle1.getMotions());
    triangle1.setMotions(new ArrayList<IMotion>(Collections.singleton(motion1)));
    assertEquals(new ArrayList<Motion>(Collections.singleton(motion1)),
        triangle1.getMotions());
    assertEquals(new ArrayList<Motion>(Collections.singleton(motion3)),
        oval1.getMotions());
    oval1.setMotions(new ArrayList<IMotion>(Collections.singleton(motion2)));
    assertEquals(new ArrayList<Motion>(Collections.singleton(motion2)),
        oval1.getMotions());
  }

  @Test
  public void testToString() {
    assertEquals("shape R Rectangle\nmotion R 5 5 5 10 5 255 255 255 10 5 20 10 5 255 255 255\n",
        rect1.toString());
    assertEquals("shape T Triangle\n"
        + "motion T 5 30 10 20 10 255 255 255 10 30 20 20 5 255 255 255\n", triangle1.toString());
    assertEquals("shape O Oval\n"
        + "motion O 25 50 10 10 5 255 255 255 30 50 5 10 5 255 255 255\n", oval1.toString());
  }

  @Test
  public void testAddMotion() {
    assertEquals(1, rect1.getMotions().size());
    rect1.addMotion(motion2);
    assertEquals(2, rect1.getMotions().size());
    assertEquals(1, triangle1.getMotions().size());
    triangle1.addMotion(motion3);
    assertEquals(2, triangle1.getMotions().size());
    assertEquals(1, oval1.getMotions().size());
    oval1.addMotion(motion2);
    assertEquals(2, oval1.getMotions().size());
  }

  @Test
  public void testRenderShape() {
    rect2.addMotion(motion1);
    oval15.addMotion(motion3);
    assertEquals(rect1.renderShape(10), rect2);
    assertEquals(triangle1.renderShape(5), triangle1);
  }


}
