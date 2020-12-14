package cs3500.animator.view;

import cs3500.animator.model.IShape;
import cs3500.animator.model.IMotion;
import cs3500.animator.model.Shape;
import java.awt.Graphics;
import java.util.Objects;

/**
 * Represents an abstract class of an IViewShape.
 */
public abstract class AViewShape implements IViewShape {

  IShape shape;

  /**
   * Constructs a AViewShape.
   *
   * @param shape the IShape to be converted
   */
  public AViewShape(IShape shape) {
    this.shape = Objects.requireNonNull(shape);
  }

  @Override
  public abstract void render(Graphics g);

  @Override
  public IViewShape interpolate(int timestamp) {
    IMotion correct = null;
    for (IMotion m : this.shape.getMotions()) {
      if ((m.getStart() <= timestamp) && (m.getEnd() >= timestamp)) {
        correct = m;
        break;
      }
    }
    if (correct == null) {
      return this;
    }
    int interval = correct.getEnd() - correct.getStart();
    int time = timestamp - correct.getStart();
    double ratio = (double) time / (double) interval;
    IShape start = new Shape(correct.getInitial());

    IShape change = new Shape(correct.getResult());
    IShape render = new Shape(start);

    render.setPos(change.getPos().change(start.getPos(), ratio)
        .add(start.getPos().getX(), start.getPos().getY()));

    render.setDim(change.getDim().change(start.getDim(), ratio)
        .add(start.getDim().getX(), start.getDim().getY()));

    render.setColor(change.getColor().change(change.getColor(), ratio).add(start.getColor()));

    return render.convert();
  }
}
