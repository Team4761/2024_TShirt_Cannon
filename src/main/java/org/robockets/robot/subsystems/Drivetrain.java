package org.robockets.robot.subsystems;

import org.robockets.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * A Subsystem for controlling the drivetrain
 * @author Jake Backer and Brian Shin
 */
public class Drivetrain extends SubsystemBase {

    public void initDefaultCommand() {
    	
    }
    
    //its mecanum
    public void driveArcade(double trans, double rot, double strafe) {
        double speedMultiplier = 0.5;
        RobotMap.robotDrive.driveCartesian(trans * speedMultiplier, strafe * speedMultiplier, rot * speedMultiplier);
    }

    /*
    public void driveTank(double leftValue, double rightValue) {
    	RobotMap.robotDrive.tankDrive(leftValue, rightValue);
    }*/
    
    public void stop() {
        RobotMap.robotDrive.driveCartesian(0, 0, 0);
    }
}

