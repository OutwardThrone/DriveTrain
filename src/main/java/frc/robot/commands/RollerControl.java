/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

public class RollerControl extends Command {
  public RollerControl() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.roller);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.roller.roll(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.oi.driver.getRawButton(OI.Button.rBumper.getButton())) {
      Robot.roller.deployRoller(true);
    } else if (Robot.oi.driver.getRawButton(OI.Button.lBumper.getButton())) {
      Robot.roller.deployRoller(false);
    } else if (Robot.oi.driver.getRawAxis(OI.Axis.rTrigger.getAxis()) > 0.1) {
      Robot.roller.deployRoller(true);
      Robot.roller.roll(0.8);
    } else if (Robot.oi.driver.getRawAxis(OI.Axis.lTrigger.getAxis()) > 0.1) {
      Robot.roller.deployRoller(true);
      Robot.roller.roll(-0.3);
    } else {
      Robot.roller.roll(0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.roller.roll(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
