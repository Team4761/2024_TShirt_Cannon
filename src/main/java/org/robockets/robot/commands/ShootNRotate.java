package org.robockets.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import org.robockets.robot.XAxisRelativeDirection;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/**
 * @author Jake Backer
 */
public class ShootNRotate extends SequentialCommandGroup {
    public ShootNRotate() {
        addCommands(
            new Shoot(),
            new WaitCommand(1),
            new RotateBarrel(XAxisRelativeDirection.LEFT)
        );
    }
}
