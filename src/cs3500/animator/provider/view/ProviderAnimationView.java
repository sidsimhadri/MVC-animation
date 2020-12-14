package cs3500.animator.provider.view;

import cs3500.animator.provider.model.Animation;
import java.io.IOException;

/**
 * Renders a {@link Animation} in some manner.
 */
public interface ProviderAnimationView {

  /**
   * Renders a model in some manner (e.g. as text, or as graphics, etc.).
   *
   * @throws IOException if the rendering fails for some reason
   */
  void render() throws IOException;


}
