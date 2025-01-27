
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LiftOperation extends Command {
  public LiftOperation() {
    requires(Robot.lift);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    //I belive this is where all button-press commands should go.
  
   // can change to buttons once we figuer out the numbers
    Robot.lift.driveTurntable(Robot.oi.interpretHatState(90,270,0.2,-0.2));

    Robot.lift.driveLift(Robot.oi.interpretHatState(0,180,0.2,-0.2));

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
