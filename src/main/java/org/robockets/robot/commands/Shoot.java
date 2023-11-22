package org.robockets.robot.commands;

import org.robockets.robot.Robot;
import org.robockets.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A Command used for shooting the t-shirt cannon.
 */
public class Shoot extends CommandBase {

    public Shoot() {
        addRequirements(Robot.shooter);
    }
    @Override
    public void initialize() {
        Robot.shooter.shoot(RobotMap.solenoid);
    }
    @Override
    public void execute() {

    }
    @Override
    public boolean isFinished() {
        return false; //why not just true
    }
    @Override
    public void end(boolean interrupted) {
    	Robot.shooter.stop(RobotMap.solenoid);
    }
}
