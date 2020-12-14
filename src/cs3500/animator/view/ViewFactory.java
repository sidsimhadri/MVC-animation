package cs3500.animator.view;

/**
 * Represents a selection of the appropriate view based off of the users request.
 */
public class ViewFactory {

  /**
   * Creates the appropriate view based off of the users given request.
   *
   * @param in the users given request
   * @return the users desired view
   */
  public AnimationView create(String in) {
    switch (in) {
      case "text":
      case "Text":
        return new TextualView();
      case "svg":
      case "Svg":
        return new SVGAnimationView();
      case "visual":
      case "Visual":
        return new JFrameView();
      case "interactive":
      case "Interactive":
        return new JFrameInteractiveView();
      default:
        throw new IllegalArgumentException("Invalid view type");
    }
  }
}
