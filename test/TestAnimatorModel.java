import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.Color;
import cs3500.animator.model.IMotion;
import cs3500.animator.model.IShape;
import cs3500.animator.model.Motion;
import cs3500.animator.model.Posn;
import cs3500.animator.model.Shape;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the AnimatorModel class of the animation.
 */
public class TestAnimatorModel {

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
  public void testAddShape() {
    ArrayList<IShape> los = new ArrayList<IShape>();
    los.add(rect1);
    los.add(triangle1);
    assertEquals(2, los.size());
    AnimatorModel model1 = new AnimatorModel(los, new Posn(70, 70));
    model1.addShape("Oval", "O", 50, 10, 10, 5,
        255, 255, 255);
    assertEquals(3, los.size());
  }

  @Test
  public void testRemoveShape() {
    ArrayList<IShape> los = new ArrayList<IShape>();
    los.add(rect1);
    los.add(triangle1);
    los.add(oval1);
    assertEquals(3, los.size());
    AnimatorModel model1 = new AnimatorModel(los, new Posn(70, 70));
    model1.removeShape("O");
    assertEquals(2, los.size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testRemoveFail() {
    ArrayList<IShape> los = new ArrayList<IShape>();
    los.add(rect1);
    los.add(triangle1);
    los.add(oval1);
    assertEquals(3, los.size());
    AnimatorModel model1 = new AnimatorModel(los, new Posn(70, 70));
    model1.removeShape("Z");
    model1.removeShape("B");
  }

  @Test
  public void testAddMotion() {
    ArrayList<IShape> los = new ArrayList<IShape>();
    los.add(rect1);
    los.add(triangle1);
    los.add(oval2);
    assertEquals(0, los.get(2).getMotions().size());
    AnimatorModel model1 = new AnimatorModel(los, new Posn(70, 70));
    model1.addMotion("O", 50, 100, 10, 5, 255, 255, 50, 100,
        30, 50, 100, 10, 5, 255, 255, 255);
    assertEquals(1, los.get(2).getMotions().size());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddFail() {
    ArrayList<IShape> los = new ArrayList<IShape>();
    los.add(rect1);
    los.add(triangle1);
    los.add(oval2);
    assertEquals(0, los.get(2).getMotions().size());
    AnimatorModel model1 = new AnimatorModel(los, new Posn(70, 70));
    model1.addMotion("Z", 50, 100, 10, 5, 255, 255, 50, 100,
        30, 50, 100, 10, 5, 255, 255, 255);
    model1.addMotion("K", 50, 100, 10, 5, 255, 255, 50, 100,
        30, 50, 100, 10, 5, 255, 255, 255);
  }

  @Test
  public void testRenderShapes() {
    ArrayList<IShape> los = new ArrayList<IShape>();
    los.add(rect1);
    los.add(triangle1);
    AnimatorModel model1 = new AnimatorModel(los, new Posn(70, 70));
    ArrayList<IShape> compare = new ArrayList<IShape>();
    compare.add(rect1);
    compare.add(triangle1);
    Assert.assertArrayEquals(model1.renderShapes(5).toArray(), compare.toArray());
  }


  @Test
  public void testToString() {
    ArrayList<IShape> los = new ArrayList<IShape>();
    los.add(rect1);
    los.add(triangle1);
    los.add(oval1);
    AnimatorModel model1 = new AnimatorModel(los, new Posn(70, 70));
    assertEquals("shape R Rectangle\n"
        + "motion R 5 5 5 10 5 255 255 255 10 5 20 10 5 255 255 255\n"
        + "\n"
        + "shape T Triangle\n"
        + "motion T 5 30 10 20 10 255 255 255 10 30 20 20 5 255 255 255\n"
        + "\n"
        + "shape O Oval\n"
        + "motion O 25 50 10 10 5 255 255 255 30 50 5 10 5 255 255 255\n"
        + "\n", model1.toString());


  }
}
