/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private WPI_TalonSRX leftMaster = null;
  private WPI_TalonSRX leftSlave = null;
  private WPI_TalonSRX rightMaster = null;
  private WPI_TalonSRX rightSlave = null;

  private DifferentialDrive drive = null;

  public Drivetrain() {
    leftMaster = new WPI_TalonSRX(RobotMap.LEFT_FRONT);
    leftSlave = new WPI_TalonSRX(RobotMap.LEFT_BACK);
    rightMaster = new WPI_TalonSRX(RobotMap.RIGHT_FRONT);
    rightSlave = new WPI_TalonSRX(RobotMap.RIGHT_BACK);

    leftMaster.setInverted(false);
    rightMaster.setInverted(true);

    leftSlave.set(ControlMode.Follower, RobotMap.LEFT_FRONT);
    rightSlave.set(ControlMode.Follower, RobotMap.RIGHT_FRONT);

    leftSlave.setInverted(InvertType.FollowMaster);
    rightSlave.setInverted(InvertType.FollowMaster);

    drive = new DifferentialDrive(leftMaster, rightMaster);
  }

  public void tankDrive(double leftPower, double rightPower) {
    drive.tankDrive(leftPower, rightPower);
  }

  public void arcadeDrive(double throttle, double turn) {
    drive.arcadeDrive(throttle, turn);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveWithJoystick());
  }
}
