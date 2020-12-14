import cs3500.animator.model.Posn;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * Tests for the Posn class of the animation.
 */
public class TestPosn {

  Posn posn1 = new Posn(5, 7);
  Posn posn2 = new Posn(100, 20);
  Posn posn3 = new Posn(20, 100);
  Posn posn4 = new Posn(40, 50);

  @Test
  public void testToString() {
    assertEquals("5 7", posn1.toString());
    assertEquals("100 20", posn2.toString());
  }

  @Test
  public void testAdd() {
    assertEquals(new Posn(105, 27), this.posn1.add(this.posn2));
    assertEquals(new Posn(60, 150), this.posn3.add(this.posn4));
  }


  @Test
  public void testChange() {
    assertEquals(new Posn(47, 6), this.posn2.change(this.posn1, 0.5));
    assertEquals(new Posn(22, 139), this.posn3.change(this.posn1, 1.5));
  }


}
