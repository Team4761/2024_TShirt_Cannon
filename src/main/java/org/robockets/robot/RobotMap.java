package org.robockets.robot;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static Victor frontLeft = new Victor(3);
	public static Victor frontRight = new Victor(2);
	public static Victor backLeft = new Victor(1);
	public static Victor backRight = new Victor(0);
	
    public static MecanumDrive robotDrive = new MecanumDrive(frontLeft, backLeft,frontRight,backRight);
	
	// Dummy ports on the encoders for now
	public static Encoder barrelRotationEncoder = new Encoder(8, 9);
	
	public static Victor barrelRotationMotor = new Victor(4);
	public static Victor barrelAngleMotor = new Victor(5);

    public static Solenoid solenoid = new Solenoid(null, 0);

	public static DigitalInput barrelLimitSwitch = new DigitalInput(4);
	
}
