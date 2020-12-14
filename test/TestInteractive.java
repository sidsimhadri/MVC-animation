import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cs3500.animator.Controller;
import cs3500.animator.model.AnimatorModel;
import cs3500.animator.view.AnimationView;
import cs3500.animator.IController;
import cs3500.animator.view.JFrameInteractiveView;
import org.junit.Test;

/**
 * Contains all tests for the interactive view.
 */
public class TestInteractive {

  AnimationView interactive = new JFrameInteractiveView();
  IController controller = new Controller(interactive, new AnimatorModel());

  @Test
  public void testGetSet() {
    assertTrue(!interactive.getPaused());
    interactive.setPaused(true);
    assertTrue(interactive.getPaused());
    assertEquals(interactive.getPlay().getActionCommand(), "play");
    assertEquals(interactive.getTick(), 1);
    assertEquals(interactive.getLooping().getActionCommand(), "loop");
  }

  @Test
  public void testListeners() {
    interactive.addListener(controller);
    assertEquals(interactive.getPlay().getActionListeners().length, 1);
    assertEquals(interactive.getLooping().getActionListeners().length, 1);
  }

}
