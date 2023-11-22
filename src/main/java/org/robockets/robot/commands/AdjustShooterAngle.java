package org.robockets.robot.commands;

import org.robockets.robot.Robot;
import org.robockets.robot.RobotMap;
import org.robockets.robot.ZAxisRelativeDirection;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * @author Brian Shin
 * A Command to adjust the barrel angle.
 */
public class AdjustShooterAngle extends CommandBase {

    private ZAxisRelativeDirection direction;

    public AdjustShooterAngle(ZAxisRelativeDirection direction) {
        addRequirements(Robot.shooter);
        this.direction = direction;
    }
    @Override
    public void initialize() {
//        setTimeout(0.4);
    }
    @Override
    public void execute() {
        Robot.shooter.changeAngle(direction);
    }
    @Override
    public boolean isFinished() {
       // return isTimedOut();
        return false;
    }
    @Override
    public void end(boolean interrupted) {
        RobotMap.barrelAngleMotor.set(0);
    }
}
