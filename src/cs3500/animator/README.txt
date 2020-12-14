Changes to model:
  Added a method to get the last tick of the providerShapes in the model.
     Added a method in IShape to get the last tick of a providerShape
  Fixed bug in builder which meant that providerShapes were not being recognized and the model was being
  built incorrectly.

Changes to existing views:
  Removed all references to model from all views:
    Added setters so the Controller can pass the necessary information to the model.
  Visual view bug fixes:
    Used the position of a providerShape in places were its dimension should be used so that's fixed now.
      Change in AViewShape's interpolate method
      Change in ViewRect and ViewOval's render method.
  Textual view changes:
     Made the words "Shape" and "Motion" all lowercase so it could be used to create a runnable
     animation from a programmatically generated model.
  SVG view bug fixes:
     changed the format of the RGB string (all colors used to be black because the string was
     formatted wrong)

Changes to controller:
  Adds listeners in go method (in try catch block so it only does it if it can and the code keeps
  running)
  Added a change listener (for interactive view speed)
  Added an actionPerformed listener (for the rest of the new interactive view functions)

Interactive view:
  the Interactive view has fields for its current:
    tick, tick speed, loop status, pause/play status, and redo status.
  It also has a field for the model's last tick
  these have setters so the controller can change their state.
    Tick only increases by tick speed if the field pause is false.
    Tick speed is set by a JSlider.
    If redo is true, then tick goes to 1, and any other necessary properties are reset.
    If loop is true, and tick is > lastTick, do the same things as redo.

