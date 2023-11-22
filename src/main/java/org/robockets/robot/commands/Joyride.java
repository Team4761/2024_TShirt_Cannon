package org.robockets.robot.commands;

import org.robockets.robot.Robot;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * @author Brian Shin
 * Drive command, connects the user input with the robot.
 */
public class Joyride extends CommandBase {
    public Joyride() {
        addRequirements(Robot.drivetrain);
    }
    @Override
    public void initialize() {
    }
    @Override
    public void execute() {
        //its mecanum i lied
    	Robot.drivetrain.driveArcade(-Robot.xbox.getLeftY(), -Robot.xbox.getLeftX(), -Robot.xbox.getRightX());
    }
    @Override
    public boolean isFinished() {
        return false;
    }
    @Override
    public void end(boolean interrupted) {
    	Robot.drivetrain.stop();
    }
}
