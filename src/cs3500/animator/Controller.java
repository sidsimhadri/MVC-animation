package cs3500.animator;

import cs3500.animator.model.IAnimatorModel;
import cs3500.animator.view.AnimationView;
import java.awt.event.ActionEvent;

import java.io.IOException;
import java.util.Objects;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;


/**
 * Represents a Controller to run all the views with an animator model.
 */
public class Controller implements IController {

  private final AnimationView view;
  private final IAnimatorModel model;
  private boolean loop = false;

  /**
   * Constructs a controller with the given params.
   * @param view the type of animation to produce
   * @param model the model to be animated
   */
  public Controller(AnimationView view, IAnimatorModel model) {
    this.view = Objects.requireNonNull(view);
    this.model = Objects.requireNonNull(model);
    this.view.setShapes(this.model.getShapes());

  }


  @Override
  public void goo(double speed, String outfile) throws IOException {

    try {
      this.view.addListener(this);
      this.view.addChange(this);
    } catch (UnsupportedOperationException e) {
      // empty catch block
    }
    this.view.render(speed, outfile);
    if (loop && (this.view.getTick() > model.lastTick())) {
      this.view.reDo();
    }

  }


  @Override
  public void stateChanged(ChangeEvent e) {
    JSlider source = (JSlider) e.getSource();
    if (!source.getValueIsAdjusting()) {
      switch (source.getValue()) {
        case 0:
          this.view.setTickSpeed(.05);
          break;
        case 25:
          this.view.setTickSpeed(.1);
          break;
        case 50:
          this.view.setTickSpeed(.3);
          break;
        case 75:
          this.view.setTickSpeed(.5);
          break;
        case 100:
          this.view.setTickSpeed(1);
          break;
        case 125:
          this.view.setTickSpeed(5);
          break;
        case 150:
          this.view.setTickSpeed(10);
          break;
        case 175:
          this.view.setTickSpeed(15);
          break;
        case 200:
          this.view.setTickSpeed(20);
          break;
        default:
          throw new IllegalArgumentException("Unexpected Input");
      }
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "play":
        if (this.view.getPaused()) {
          this.view.setPaused(false);
          this.view.getPlay().setText("pause");
        } else {
          this.view.setPaused(true);
          this.view.getPlay().setText("play");
        }
        break;
      case "restart":
        this.view.reDo();
        break;
      case "loop":
        if (loop) {
          view.setLooping(false);
          this.view.getLooping().setText("loop");
        } else {
          view.setLooping(true);
          this.view.getLooping().setText("unloop");
        }
        break;
      default:
        throw new IllegalArgumentException("Unexpected Input");
    }
  }
}
