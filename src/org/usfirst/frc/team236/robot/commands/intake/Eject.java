package org.usfirst.frc.team236.robot.commands.intake;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Eject extends Command {

    public Eject() {
        requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.intake.leftIntake.set(RobotMap.IntakeMap.EJECT_SPEED);
    	Robot.intake.rightIntake.set(RobotMap.IntakeMap.EJECT_SPEED);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.intake.stop();
    }

    protected void interrupted() {
    	end();
    }
}
