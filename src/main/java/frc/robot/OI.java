
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
     
  
  //Controllers
  public Joystick driverPad = new Joystick(1);

  //Setting up the flightstick. As written *should* only work when driverpad is also on. Try switching Joystick(1) to Joystick (0) to function without. Be sure to change driverPad to Joystick(1)
  public Joystick fStick = new Joystick(0);




private double FSTICK_DEADBAND = 0.05;
private static final double XFSTICK_DEADBAND = 0.1;

//deadband math

private static double stickDeadband(double value, double deadband, double center) {
    return (value < (center + deadband) && value > (center - deadband)) ? center : value;
}



private static double fStickDeadband(double value, double deadband, double center) {
    return (value < (center + deadband) && value > (center - deadband)) ? center : value;
}



public double getFstickX() {
    return fStickDeadband(this.driverPad.getRawAxis(FStickMap.XAXIS), FSTICK_DEADBAND, 0.0);
    //return fStickDeadband(this.fStick.getRawAxis(FStickMap.XAXIS), XFSTICK_DEADBAND, 0.0);
}

public double getFstickY() {
    return fStickDeadband(this.fStick.getRawAxis(FStickMap.YAXIS), FSTICK_DEADBAND, 0.0);
}


public double getFstickZ() {
    return fStickDeadband(this.fStick.getRawAxis(FStickMap.ZAXIS), FSTICK_DEADBAND, 0.0);
}

public double getFThrottle(){
    return this.fStick.getRawAxis(FStickMap.THROTTLE);
}
public double getMultiplier(double axis, double throttle){
  
  // throttle is backwards goes from 1 t0 -1
  if (throttle >=-1 && throttle <=-0.5){
  throttle = 1;
  FSTICK_DEADBAND = .05;
  }
  else if (throttle>-0.5 && throttle <= 0){
  throttle = .75;
  FSTICK_DEADBAND = .05;
  }
  else if (throttle> 0 && throttle <= 0.5){
  throttle = .5;
  FSTICK_DEADBAND = .05;
  }
  else if (throttle > 0.5 && throttle <= 1){

  
  throttle = .25;
  FSTICK_DEADBAND = 0.1;
  }
  return axis*throttle;

}


}
