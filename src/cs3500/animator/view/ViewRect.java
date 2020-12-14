package cs3500.animator.view;

import cs3500.animator.model.IShape;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * Represents the view version of a Rectangle shape.
 */
public class ViewRect extends AViewShape implements IViewShape {

  /**
   * Constructs a ViewRect.
   *
   * @param rect the rectangle to be converted.
   */
  public ViewRect(IShape rect) {
    super(rect);
  }

  @Override
  public void render(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    g2.setColor(this.shape.getColor().paintColor());
    g2.fillRect(this.shape.getPos().getX(), this.shape.getPos().getY(),
        this.shape.getDim().getX(),
        this.shape.getDim().getY());
  }
}
