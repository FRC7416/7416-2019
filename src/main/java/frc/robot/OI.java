
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
     
  
  //Controllers
  public Joystick driverPad = new Joystick(1);

  //Setting up the flightstick. As written *should* only work when driverpad is also on. Try switching Joystick(1) to Joystick (0) to function without. Be sure to change driverPad to Joystick(1)
  public Joystick fStick = new Joystick(0);


//deadband values for both controllers. 0.05 seems like a good option. 0.01 has issues at extremely low throttles, while anything above .1 is far too high
private static final double STICK_DEADBAND = 0.05;

//testing required for optimal fstick deadbands. my inital thought is that smaller is better but i'm unsure.
private static final double FSTICK_DEADBAND = 0.05;
private static final double XFSTICK_DEADBAND = 0.08;

//deadband math
private static double stickDeadband(double value, double deadband, double center) {
    return (value < (center + deadband) && value > (center - deadband)) ? center : value;
}


//all the following "get" methods pull the raw data from the controller and adjust for deadband.
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



//Repeat of driver pad "get" code for the flightstick. Only one stick but has 3 axis, z = twist 

private static double fStickDeadband(double value, double deadband, double center) {
    return (value < (center + deadband) && value > (center - deadband)) ? center : value;
}



public double getFstickX() {
    return fStickDeadband(this.fStick.getRawAxis(FStickMap.XAXIS), XFSTICK_DEADBAND, 0.0);
}

public double getFstickY() {
    return fStickDeadband(this.fStick.getRawAxis(FStickMap.YAXIS), FSTICK_DEADBAND, 0.0);
}

// thinking either arc turning or manual lift control. 

public double getFstickZ() {
    return fStickDeadband(this.fStick.getRawAxis(FStickMap.ZAXIS), FSTICK_DEADBAND, 0.0);
}

public double getFThrottle(){
    return this.fStick.getRawAxis(FStickMap.THROTTLE);
}
public double getMultiplier(double axis, double throttle){
  //throttle = -throttle;
  // throttle is backwards
  if (throttle >=-1 && throttle <=-0.6)
  throttle = 1;
  else if (throttle>-0.6 && throttle <= -0.2)
  throttle = .8;
  else if (throttle>-0.2 && throttle <= 0.2)
  throttle = .6;
  else if (throttle >.2 && throttle <= 0.6)
  throttle = .4;
  else if (throttle >.6 && throttle <= 1)
  throttle = .2;
  return axis*throttle;
}

}
