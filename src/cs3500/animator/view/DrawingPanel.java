package cs3500.animator.view;

import cs3500.animator.model.IShape;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 * Represents a Drawing panel to draw the shapes to appear in the view.
 */
public class DrawingPanel extends JPanel {

  List<IViewShape> shapes;


  /**
   * Constructs a drawingpanel with the given params.
   *
   * @param w the width of the panel.
   * @param h the height of the pane.
   */
  public DrawingPanel(int w, int h) {
    super();
    setPreferredSize(new Dimension(w, h));
    setBackground(Color.YELLOW);
    shapes = new ArrayList<>();
  }

  /**
   * Paints this drawing panel given this graphic.
   *
   * @param g the graphic used to paint
   */
  @Override
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    super.paint(g2);
    for (IViewShape shape : shapes) {
      shape.render(g2);
    }
    shapes.clear();
  }

  /**
   * Adds a shape to this drawing panel.
   *
   * @param shape the shape to add to the drawing panel
   */
  public void drawShape(IViewShape shape) {
    shapes.add(shape);
  }

  /**
   * Sets the shapes in this drawing panel to the given list of shapes.
   *
   * @param iShapes the list of shapes to set the shapes to
   */
  public void setShapes(List<IShape> iShapes) {
    List<IViewShape> result = new ArrayList<>();
    for (IShape s : iShapes) {
      switch (s.getType()) {
        case "Rectangle":
        case "rectangle":
          result.add(new ViewRect(s));
          break;
        case "Oval":
        case "Ellipse":
        case "oval":
        case "ellipse":
          result.add(new ViewOval(s));
          break;
        default:
          throw new IllegalArgumentException("invalid shape");
      }
    }
    this.shapes = result;
  }
}
