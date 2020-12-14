import cs3500.animator.Controller;
import cs3500.animator.model.AnimatorModel;
import cs3500.animator.model.IAnimatorModel;
import cs3500.animator.model.IShape;
import cs3500.animator.view.AnimationView;
import cs3500.animator.IController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JSlider;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Tests for the Controller class.
 */
public class TestController {

  IAnimatorModel model = new AnimatorModel();
  IController controller;
  JSlider slider = new JSlider(0, 200);
  ChangeEvent slideChange = new ChangeEvent(slider);
  StringBuilder inputs;

  class MockView implements AnimationView {

    Appendable ap;

    public MockView(Appendable ap) {
      this.ap = ap;
    }

    @Override
    public void setShapes(ArrayList<IShape> shapes) {
      // do nothing
    }

    @Override
    public void render(double speed, String outfile) {
      try {
        ap.append("rendering");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void refresh() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void drawShapes(int time) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void writeOutUsingBufferedWriter(String output, String outfile) throws IOException {
      throw new UnsupportedOperationException();
    }

    @Override
    public String xmlModel(double speed) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setPaused(Boolean b) {
      try {
        ap.append(b + "");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public boolean getPaused() {
      return false;
    }

    @Override
    public JButton getPlay() {
      return new JButton();
    }

    @Override
    public void addListener(ActionListener listener) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void addChange(ChangeListener listener) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setTickSpeed(double value) {
      try {
        ap.append(value + "");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public JButton getLooping() {
      return new JButton();
    }

    @Override
    public void reDo() {
      try {
        ap.append("reDo");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public int getTick() {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setX(int x) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setY(int y) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setTopX(int x) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setTopY(int y) {
      throw new UnsupportedOperationException();
    }

    @Override
    public void setLooping(boolean b) {
      try {
        ap.append("looping");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void setLastTick(int t) {
      throw new UnsupportedOperationException();
    }
  }

  @Before
  public void setUp() {
    inputs = new StringBuilder();
    AnimationView view = new MockView(inputs);
    model = new AnimatorModel();
    controller = new Controller(view, model);
  }

  @Test
  public void testSlider() {
    this.slider.setValue(0);
    controller.stateChanged(slideChange);
    assertTrue(inputs.toString().contains(".05"));
    inputs.setLength(0);
    this.slider.setValue(25);
    controller.stateChanged(slideChange);
    assertTrue(inputs.toString().contains(".1"));
    inputs.setLength(0);
    this.slider.setValue(50);
    controller.stateChanged(slideChange);
    assertTrue(inputs.toString().contains(".3"));
    inputs.setLength(0);
    this.slider.setValue(75);
    controller.stateChanged(slideChange);
    assertTrue(inputs.toString().contains(".5"));
    inputs.setLength(0);
    this.slider.setValue(100);
    controller.stateChanged(slideChange);
    assertTrue(inputs.toString().contains("1"));
    inputs.setLength(0);
    this.slider.setValue(125);
    controller.stateChanged(slideChange);
    assertTrue(inputs.toString().contains("5"));
    inputs.setLength(0);
    this.slider.setValue(150);
    controller.stateChanged(slideChange);
    assertTrue(inputs.toString().contains("10"));
    inputs.setLength(0);
    this.slider.setValue(175);
    controller.stateChanged(slideChange);
    assertTrue(inputs.toString().contains("15"));
    inputs.setLength(0);
    this.slider.setValue(200);
    controller.stateChanged(slideChange);
    assertTrue(inputs.toString().contains("20"));

  }

  @Test
  public void testButtons() {
    JButton test = new JButton();
    ActionEvent a = new ActionEvent(test, 1, "play");
    controller.actionPerformed(a);
    assertTrue(inputs.toString().contains("true"));
    inputs.setLength(0);
    a = new ActionEvent(test, 1, "restart");
    controller.actionPerformed(a);
    assertTrue(inputs.toString().contains("reDo"));
    inputs.setLength(0);
    a = new ActionEvent(test, 1, "loop");
    controller.actionPerformed(a);
    assertTrue(inputs.toString().contains("looping"));
    inputs.setLength(0);
    try {
      controller.goo(2, "hello");
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertTrue(inputs.toString().contains("rendering"));
  }
}
