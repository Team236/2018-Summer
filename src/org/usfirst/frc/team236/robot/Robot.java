/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team236.robot;

import org.usfirst.frc.team236.robot.subsystems.Drive;
import org.usfirst.frc.team236.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
	
	public static OI oi;
	
	public static Drive drive = new Drive();
	public static Intake intake = new Intake();
	
	@Override
	public void robotInit() {
		oi = new OI();
		
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {

		//if (m_autonomousCommand != null) {
		//	m_autonomousCommand.start();
		//}
	}


	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
		//if (m_autonomousCommand != null) {
		//	m_autonomousCommand.cancel();
		//}
		
		drive.resetEncoders();
		drive.navx.reset();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		//put sensor values on smartdashboard
		SmartDashboard.putNumber("Left Distance", drive.getLeftDist());
		SmartDashboard.putNumber("Right Distance", drive.getRightDist());
		
		SmartDashboard.putNumber("Gyro Angle", drive.navx.getAngle());
	}

	@Override
	public void testPeriodic() {
	}
}
