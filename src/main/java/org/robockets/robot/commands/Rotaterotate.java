package org.robockets.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.robockets.robot.Robot;
import org.robockets.robot.XAxisRelativeDirection;

/**
 * @author Jake Backer
 */
public class Rotaterotate extends CommandBase {

    XAxisRelativeDirection direction;

    public Rotaterotate(XAxisRelativeDirection direction) {
        addRequirements(Robot.barrel);
        this.direction = direction;
    }
    @Override
    public void initialize() {

    }
    @Override
    public void execute() {
        Robot.barrel.rotate(direction);
    }
    @Override
    public boolean isFinished() {
        return false;
    }
    @Override
    public void end(boolean interrupted) {
        Robot.barrel.stop();
    }
}
