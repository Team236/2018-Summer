package org.usfirst.frc.team236.robot.commands.intake;

import org.usfirst.frc.team236.robot.Robot;
import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Intake extends Command {

    public Intake() {
        requires(Robot.intake);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (!Robot.intake.intakeSensor.get()) {
    		Robot.intake.leftIntake.set(RobotMap.IntakeMap.INTAKE_SPEED);
    		Robot.intake.rightIntake.set(RobotMap.IntakeMap.INTAKE_SPEED);
    	}
    }

    protected boolean isFinished() {
        return Robot.intake.intakeSensor.get();
    }

    protected void end() {
    	Robot.intake.stop();
    }

    protected void interrupted() {
    	end();
    }
}
