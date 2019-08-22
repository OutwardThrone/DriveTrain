/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.RollerControl;

/**
 * Add your docs here.
 */
public class Roller extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX roller;
  private Solenoid rollerSolenoid;


  public Roller() {
    roller = new WPI_TalonSRX(RobotMap.ROLLER);
    rollerSolenoid = new Solenoid(RobotMap.ROLLER_SOLENOID);

    roller.setInverted(false);
  }

  /**
   * 
   * @param power power to set the roller between -1 and 1
   */
  public void roll(double power) {
    roller.set(power);
  }

  /**
   * 
   * @param deploy true to deploy, false to retract
   */
  public void deployRoller(boolean deploy) {
    rollerSolenoid.set(deploy);
  }

  public boolean isDeployed() {
    return rollerSolenoid.get();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new RollerControl());
  }
}
