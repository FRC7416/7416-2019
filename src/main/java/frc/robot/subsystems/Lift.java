
package frc.robot.subsystems;

import javax.lang.model.util.ElementScanner6;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;


public class Lift extends Subsystem {
private VictorSP turntable = new VictorSP(RobotMap.TURNTABLE_MOTOR);
private VictorSP liftMotor = new VictorSP(RobotMap.LIFT_MOTOR);

// private double dpp= 10; // Not sure what this needs to be yet need to test
// private double desiredDistanceLift = 400;// not sure what this needs to be yet need to test
// private double desiredDistanceTurn = 600;// not sure what this needs to be yet need to test
// private Encoder liftEnc = new Encoder(0, 1, true);// Need to set it to the right channal
// private Encoder TurnableEnc = new Encoder(0, 1, true);// Need to set it to the right channal

public Lift (){
 turntable.setInverted(false);
 liftMotor.setInverted(false);
//  liftEnc.setDistancePerPulse(dpp);
} 



public void driveLift(double speed)
{
// stops the lift once it reachs the right point we can changes this to buttens once we have the numbers up above right
// this only works is speed changes goes form negative to postive to go up and down
// and if getDistance does direction too if not just add in a getDiraction and a counter.  
  if (liftEnc.getDistance() >= desiredDistanceLift && speed >0)
  {
    liftMotor.set(0);
  }
  else if (liftEnc.getDistance() <= 0 && speed <0)
  {
    liftMotor.set(0);
  }
  else
  {
    liftMotor.set(speed);
  }

}

public void driveTurntable(double speed)
{
// stops drice turnable once it reachs the right point we can change to buttens once we have the numbers up above right
// This only runs once then locks
  if (TurnableEnc.getDistance() >= desiredDistanceTurn)
    {
      turntable.setDisabled();
    }
    else
    {
      turntable.set(speed);
    }
}
@Override
  public void initDefaultCommand() {
    setDefaultCommand(new LiftOperation());
  }
  
}
