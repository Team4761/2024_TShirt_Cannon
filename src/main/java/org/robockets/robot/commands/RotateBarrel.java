package org.robockets.robot.commands;

import org.robockets.robot.Robot;
import org.robockets.robot.RobotMap;
import org.robockets.robot.XAxisRelativeDirection;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A Command that rotates the Barrel
 * @author Jake Backer
 */

public class RotateBarrel extends CommandBase {

	private XAxisRelativeDirection direction;

    private boolean started;
    private boolean finished;
	
    public RotateBarrel(XAxisRelativeDirection direction) {
        addRequirements(Robot.barrel);
        this.direction = direction;

    }
    @Override
    public void initialize() {
        started = true;
        finished = false;
    }
    @Override
    public void execute() {
        Robot.barrel.rotate(direction);

        if (started) {
            started = !RobotMap.barrelLimitSwitch.get();
        } else {
            finished = !RobotMap.barrelLimitSwitch.get();
        }

    }
    @Override
    public boolean isFinished() {
        return finished;
    }
    @Override
    public void end(boolean interrupted) {
    	RobotMap.barrelRotationMotor.set(0);
    }

}
