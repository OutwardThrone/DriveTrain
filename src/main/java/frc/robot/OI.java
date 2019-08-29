/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.MoveArm;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
  public static enum Button {
    A(0),
    B(1),
    X(2),
    Y(3),
    rBumper(4),
    lBumper(5),
    start(6),
    back(7),
    lJoyButton(8),
    rJoyButton(9);

    private int buttonID;

    private Button(int buttonID) {
      this.buttonID = buttonID;
    }

    public int getButton() {
      return buttonID;
    }
  }

  public static enum Axis {
    lJoyX(0),
    lJoyY(1),
    rJoyX(2),
    rJoyY(3),
    lTrigger(4),
    rTrigger(5);

    private int axisID;

    private Axis(int axisID) {
      this.axisID = axisID;
    }

    public int getAxis() {
      return axisID;
    }
  }

  public Joystick driver;
  public Joystick operator;
  public JoystickButton armUpBtn, armDownBtn;

  public OI() {
    driver = new Joystick(0);
    operator = new Joystick(1);

    armUpBtn = new JoystickButton(driver, Button.Y.getButton());
    armDownBtn = new JoystickButton(driver, Button.A.getButton());
    
    armUpBtn.whenPressed(new MoveArm(0.8, 0.95));
    armDownBtn.whenPressed(new MoveArm(-0.2, 1.5));
  }
}
