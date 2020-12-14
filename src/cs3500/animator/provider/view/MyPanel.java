package cs3500.animator.provider.view;

import cs3500.animator.provider.model.AbstractAnimation;
import cs3500.animator.provider.model.ProviderMotion;
import cs3500.animator.provider.model.ProviderShape;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.List;
import javax.swing.JPanel;

/**
 * Main Panel, for display the shapes Swing components that actually display the animation.
 */
class MyPanel extends JPanel {

  /**
   * current tick.
   */
  private int tick;
  private final AbstractAnimation<ProviderMotion> animation;

  /**
   * Constructor for Panel.
   *
   * @param animation animation
   */
  MyPanel(AbstractAnimation<ProviderMotion> animation) {
    this.animation = animation;
    tick = 0;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    List<ProviderShape> providerShapes = animation.getShapes(tick++);
    int x = animation.getCanvas().getX();
    int y = animation.getCanvas().getY();
    for (ProviderShape providerShape : providerShapes) {
      RectangularShape rectangularShape = null;
      if (providerShape.getShapeName().equalsIgnoreCase("rectangle")) {
        rectangularShape = new Rectangle2D.Double(providerShape.getPosition().getX() - x,
            providerShape.getPosition().getY() - y, providerShape.getWidth(),
            providerShape.getHeight());
      } else if (providerShape.getShapeName().equalsIgnoreCase("ellipse")
          || providerShape.getShapeName().equalsIgnoreCase("oval")) {
        rectangularShape = new Ellipse2D.Double(providerShape.getPosition().getX() - x,
            providerShape.getPosition().getY() - y, providerShape.getWidth(),
            providerShape.getHeight());
      }
      g2.setColor(
          new Color((int) providerShape.getColor().getRed(),
              (int) providerShape.getColor().getGreen(),
              (int) providerShape.getColor().getBlue()));
      if (rectangularShape != null) {
        g2.fill(rectangularShape);
      }
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(animation.getCanvas().getWidth(), animation.getCanvas().getHeight());
  }

  public void setTick(int tick) {
    this.tick = tick;
  }
}