package org.robockets.robot.subsystems;

import org.robockets.robot.RobotMap;
import org.robockets.robot.ZAxisRelativeDirection;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/**
 * A Subsystem that controls the shooter
 */
public class Shooter extends SubsystemBase {

	public Shooter() {

	}
	
    public void initDefaultCommand() {
    	
    }
    
    public void shoot(Solenoid solenoid) {
    	//Robot.pneumatics.shooterFill(solenoid);
		solenoid.set(true);
    }
    
    public void changeAngle(ZAxisRelativeDirection direction) {

		if (direction == ZAxisRelativeDirection.UP) {
			RobotMap.barrelAngleMotor.set(-0.5);
		} else if (direction == ZAxisRelativeDirection.DOWN) {
			RobotMap.barrelAngleMotor.set(0.5);
		}
    }

	public void stop(Solenoid solenoid) {
		solenoid.set(false);
		RobotMap.barrelAngleMotor.set(0);
	}
}

