package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	
	public DigitalInput intakeSensor;
	
	public SpeedController leftIntake, rightIntake;
	
	public Intake() {
		
		intakeSensor = new DigitalInput(RobotMap.IntakeMap.DIO_SENSOR);
		
		leftIntake = new VictorSP(RobotMap.IntakeMap.PWM_LEFT);
		rightIntake = new VictorSP(RobotMap.IntakeMap.PWM_RIGHT);
	}
	
	public void setSpeed(double speed) {
		leftIntake.set(speed);
		rightIntake.set(speed);
	}
	
	public void stop() {
		setSpeed(0);
	}
	
	public boolean isCube() {
		return intakeSensor.get();
	}
	
    public void initDefaultCommand() {
        
    }
}

