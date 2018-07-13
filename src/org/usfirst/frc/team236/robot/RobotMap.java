/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team236.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static class DriveMap {
		public static final int ID_LEFT_FRONT = 2;
		public static final int ID_LEFT_MIDDLE = 4;
		public static final int ID_LEFT_REAR = 10;

		public static final int ID_RIGHT_FRONT = 14;
		public static final int ID_RIGHT_MIDDLE = 3;
		public static final int ID_RIGHT_REAR = 9;
	}
	
	public static class JoystickMap {
		public static final int USB_LEFT = 0;
		public static final int USB_RIGHT = 1;
		public static final int USB_CONTROLLER = 2;
	}
}
