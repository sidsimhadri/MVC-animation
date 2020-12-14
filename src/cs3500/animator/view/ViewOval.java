package cs3500.animator.view;

import cs3500.animator.model.IShape;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Represents the view version of an oval shape.
 */
public class ViewOval extends AViewShape implements IViewShape {

  /**
   * Constructs a ViewOval.
   *
   * @param oval the oval to be converted.
   */
  public ViewOval(IShape oval) {
    super(oval);
  }

  @Override
  public void render(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setPaint(this.shape.getColor().paintColor());
    g2.fillOval(this.shape.getPos().getX(), this.shape.getPos().getY(), this.shape.getDim().getX(),
        this.shape.getDim().getY());
  }
}
