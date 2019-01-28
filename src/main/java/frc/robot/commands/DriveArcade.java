
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveArcade extends Command {
  public DriveArcade() {
    requires(Robot.drivetrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
   
    
    Robot.drivetrain.driveArcade(Robot.oi.getMultiplier(Robot.oi.getFstickY(),Robot.oi.getFThrottle()), Robot.oi.getMultiplier(Robot.oi.getFstickX(),Robot.oi.getFThrottle()));

    
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
