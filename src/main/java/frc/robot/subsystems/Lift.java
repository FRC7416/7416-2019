
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;


public class Lift extends Subsystem {
private VictorSP turntable = new VictorSP(RobotMap.TURNTABLE_MOTOR);
private VictorSP liftMotor = new VictorSP(RobotMap.LIFT_MOTOR);

 
// private Encoder leftEnc = new Encoder(0, 1, true);
public Lift (){
 turntable.setInverted(false);
 liftMotor.setInverted(false);

} 



public void driveLift(double speed)
{
  liftMotor.set(speed);
 
 
}

public void driveTurntable(double speed)
{
  turntable.set(speed);
}
@Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftOperation());
  }
  
}
