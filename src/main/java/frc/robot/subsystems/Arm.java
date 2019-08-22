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
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private WPI_TalonSRX rightMaster;
  private WPI_TalonSRX rightSlave;
  private WPI_TalonSRX leftMaster;
  private WPI_TalonSRX leftSlave;

  public Arm() {
    rightMaster = new WPI_TalonSRX(RobotMap.RIGHT_MASTER_ARM);
    rightSlave = new WPI_TalonSRX(RobotMap.RIGHT_SLAVE_ARM);
    leftMaster = new WPI_TalonSRX(RobotMap.LEFT_MASTER_ARM);
    leftSlave = new WPI_TalonSRX(RobotMap.LEFT_SLAVE_ARM);

    rightSlave.set(ControlMode.Follower, RobotMap.RIGHT_MASTER_ARM);
    leftSlave.set(ControlMode.Follower, RobotMap.LEFT_MASTER_ARM);

    rightMaster.setInverted(true);
    leftMaster.setInverted(false);

    rightSlave.setInverted(InvertType.FollowMaster);
    leftSlave.setInverted(InvertType.FollowMaster);
  }

  public void set(double power) {
    rightMaster.set(power);
    leftMaster.set(power);
  }

  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
