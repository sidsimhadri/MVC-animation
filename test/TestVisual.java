
import cs3500.animator.Controller;
import cs3500.animator.model.AnimatorModel;
import cs3500.animator.view.AnimationView;
import cs3500.animator.IController;
import cs3500.animator.view.JFrameView;

import org.junit.Test;

/**
 * Tests all relevant JFrame View methods.
 */
public class TestVisual {


  @Test(expected = UnsupportedOperationException.class)
  public void testUnsupported() {
    AnimationView visual = new JFrameView();
    IController controller = new Controller(visual, new AnimatorModel());
    visual.setPaused(false);
    visual.addListener(controller);
    visual.addChange(controller);
    visual.setTickSpeed(1.0);
    visual.getTick();
    visual.reDo();
    visual.setLooping(false);
    visual.setLastTick(1);
    visual.getLooping();
  }







}
