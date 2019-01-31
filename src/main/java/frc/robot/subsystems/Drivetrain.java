
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;


public class Drivetrain extends Subsystem {
private VictorSP leftMain = new VictorSP(RobotMap.LEFT_MAIN_MOTOR);
<<<<<<< HEAD

=======
>>>>>>> fe95c546193f790dc33a641509e2d143d5b92a7d
private VictorSP rightMain = new VictorSP(RobotMap.RIGHT_MAIN_MOTOR);

 
private Encoder liftEnc = new Encoder(0, 1, true);
public Drivetrain (){
  leftMain.setInverted(false);
<<<<<<< HEAD
  rightMain.setInverted(true);
=======
  
  rightMain.setInverted(true);
 
>>>>>>> fe95c546193f790dc33a641509e2d143d5b92a7d
} 

public void driveArcade(double throttle, double turn) {
  drive(throttle + turn, throttle - turn);
  
}

public void drive(double left, double right)
{
  leftMain.set(left);
<<<<<<< HEAD
  rightMain.set(right);
=======
  
  rightMain.set(right);
 
>>>>>>> fe95c546193f790dc33a641509e2d143d5b92a7d
}
@Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveArcade());
  }
  
}
