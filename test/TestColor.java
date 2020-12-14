import org.junit.Test;
import cs3500.animator.model.Color;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the Color class of the animation.
 */
public class TestColor {

  Color color1 = new Color(255, 255, 255);
  Color color2 = new Color(128, 0, 0);
  Color color3 = new Color(64, 128, 128);
  Color color4 = new Color(192, 128, 128);

  @Test
  public void testToString() {
    assertEquals("255 255 255", color1.toString());
    assertEquals("128 0 0", color2.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {
    new Color(-1, 0, 0);
    new Color(0, 0, -1);
    new Color(0, -1, 0);
    new Color(0, 300, 0);
    new Color(300, 0, 0);
    new Color(0, 0, 300);
  }

  @Test
  public void testConstructed() {
    Color a = new Color(1, 0, 1);
    Color b = new Color(0, 1, 1);
    Color c = new Color(1, 1, 0);
    assertEquals(a, new Color(1, 0, 1));
    assertEquals(b, new Color(0, 1, 1));
    assertEquals(c, new Color(1, 1, 0));

  }

  @Test
  public void testChange() {
    assertEquals(color1.change(color2, .5), color3);
  }

  @Test
  public void testAdd() {
    assertEquals(color2.add(color3), color4);
  }

}
