package org.robockets.robot;

import org.robockets.robot.commands.*;
import org.robockets.robot.subsystems.*;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {

	public static Shooter shooter;
	public static Barrel barrel;
	public static Drivetrain drivetrain;

    Command autonomousCommand;

    public static XboxController xbox = new XboxController(0);

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
      shooter = new Shooter();
      barrel = new Barrel();
      drivetrain = new Drivetrain();

      //SmartDashboard.putNumber("Driving Speed", Drivetrain.DEFAULT_SPEED);
    }

    public void robotPeriodic() {
    	//SmartDashboard.putBoolean("LimitSwitch", RobotMap.barrelLimitSwitch.get());
	}
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    	
    }
	
	public void disabledPeriodic() {
		CommandScheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
       
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        CommandScheduler.getInstance().run();
    }

    public void teleopInit() {
      CommandScheduler.getInstance().schedule(new Joyride());
      /* what is this
      SmartDashboard.putData(new Shoot());
      SmartDashboard.putData("Rotate Left", new RotateBarrel(XAxisRelativeDirection.LEFT));
      SmartDashboard.putData("Rotate Right", new RotateBarrel(XAxisRelativeDirection.RIGHT));

      SmartDashboard.putData("Angle Up", new AdjustShooterAngle(ZAxisRelativeDirection.UP));
      SmartDashboard.putData("Angle Down", new AdjustShooterAngle(ZAxisRelativeDirection.DOWN));

      SmartDashboard.putNumber("SolenoidTimeout", 0.05);
      */

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        CommandScheduler.getInstance().run();

        //this can all be trigger commands but not doing that right now
        
        if(xbox.getLeftBumperReleased()) {
          CommandScheduler.getInstance().schedule(new Shoot().withTimeout(0.05)); //taken from smartdashboard originally
        }
        if(xbox.getRightBumperReleased()) {
          CommandScheduler.getInstance().schedule(new ShootNRotate());
        }
        if(xbox.getBButtonReleased()) {
          CommandScheduler.getInstance().schedule(new RotateBarrel(XAxisRelativeDirection.RIGHT));
        }
        if(xbox.getXButtonReleased()) {
          CommandScheduler.getInstance().schedule(new RotateBarrel(XAxisRelativeDirection.LEFT));
        }
        if(xbox.getYButton()) {
          CommandScheduler.getInstance().schedule(new AdjustShooterAngle(ZAxisRelativeDirection.UP));
        }
        if(xbox.getAButton()) {
          CommandScheduler.getInstance().schedule(new AdjustShooterAngle(ZAxisRelativeDirection.DOWN));
        }
        if(xbox.getBackButton()) {
          CommandScheduler.getInstance().schedule(new Rotaterotate(XAxisRelativeDirection.LEFT));
        }
        if(xbox.getStartButton()) {
          CommandScheduler.getInstance().schedule(new Rotaterotate(XAxisRelativeDirection.RIGHT));
        }

		//SmartDashboard.putBoolean("LimitSwitch Value", RobotMap.barrelLimitSwitch.get());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    }
}
