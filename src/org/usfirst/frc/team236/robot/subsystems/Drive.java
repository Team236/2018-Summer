package org.usfirst.frc.team236.robot.subsystems;

import org.usfirst.frc.team236.robot.RobotMap;
import org.usfirst.frc.team236.robot.commands.drive.DriveWithJoysticks;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	
	public TalonSRX leftFront, leftMiddle, leftRear;
	public TalonSRX rightFront, rightMiddle, rightRear;
	
	public AHRS navx;
	
	public Drive() {
		//create talons
		leftFront = new TalonSRX(RobotMap.DriveMap.ID_LEFT_FRONT);
		leftMiddle = new TalonSRX(RobotMap.DriveMap.ID_LEFT_MIDDLE);
		leftRear = new TalonSRX(RobotMap.DriveMap.ID_LEFT_REAR);
		rightFront = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_FRONT);
		rightMiddle = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_MIDDLE);
		rightRear = new TalonSRX(RobotMap.DriveMap.ID_RIGHT_REAR);
		
		navx = new AHRS(SPI.Port.kMXP);
		
		//set middle and back talons to follow the front
		leftMiddle.set(ControlMode.Follower, leftFront.getDeviceID());
		leftRear.set(ControlMode.Follower, leftFront.getDeviceID());
		rightMiddle.set(ControlMode.Follower, rightFront.getDeviceID());
		rightRear.set(ControlMode.Follower, rightFront.getDeviceID());
		
		//set "true" if necessary to make encoders read positive when talon blinks green
		leftFront.setSensorPhase(true);
		rightFront.setSensorPhase(false);
	}
    
    public void setLeftSpeed(double speed) {
    	leftFront.set(ControlMode.PercentOutput, speed);
    }
    
    public void setRightSpeed(double speed) {
    	rightFront.set(ControlMode.PercentOutput, speed);
    }
    
    public void stop() {
    	setLeftSpeed(0);
    	setRightSpeed(0);
    }
    
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void pidSet(double speed) {
    	setLeftSpeed(speed);
    	setRightSpeed(-speed);
    }
    
    //getting encoder and gyro values
    public void resetEncoders() {
    	leftFront.setSelectedSensorPosition(0, 0, 0);
    	rightFront.setSelectedSensorPosition(0, 0, 0);
    }
    
    public double getLeftDist() {
    	return leftFront.getSelectedSensorPosition(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE;
    }
    
    public double getRightDist() {
    	return rightFront.getSelectedSensorPosition(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE;
    }
    
    public double getLeftSpeed() {
    	return leftFront.getSelectedSensorVelocity(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE;
    }
    
    public double getRightSpeed() {
    	return rightFront.getSelectedSensorVelocity(0) * RobotMap.DriveMap.DISTANCE_PER_PULSE;
    }
    
    
}

