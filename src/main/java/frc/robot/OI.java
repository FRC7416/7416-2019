
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
     
  
  //Controllers
  public Joystick driverPad = new Joystick(0);
  public Joystick opPad = new Joystick(1);

private static final double STICK_DEADBAND = 0.05;

private static double stickDeadband(double value, double deadband, double center) {
    return (value < (center + deadband) && value > (center - deadband)) ? center : value;
}

public double getDriverLeftStickY() {
    return stickDeadband(this.driverPad.getRawAxis(JoystickMap.LEFT_Y), STICK_DEADBAND, 0.0);
}

public double getDriverLeftStickX() {
    return stickDeadband(this.driverPad.getRawAxis(JoystickMap.LEFT_X), STICK_DEADBAND, 0.0);
}

public double getDriverRightStickY() {
    return stickDeadband(this.driverPad.getRawAxis(JoystickMap.RIGHT_Y), STICK_DEADBAND, 0.0);
}

public double getDriverRightStickX() {
    return stickDeadband(this.driverPad.getRawAxis(JoystickMap.RIGHT_X), STICK_DEADBAND, 0.0);
}

public double getDriverTriggerSum() {
    return this.driverPad.getRawAxis(JoystickMap.RIGHT_TRIGGER) - this.driverPad.getRawAxis(JoystickMap.LEFT_TRIGGER); //TODO: Check Axis (Right - Left)
}

}
