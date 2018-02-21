package org.usfirst.frc.team3695.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3695.robot.commands.*;
import org.usfirst.frc.team3695.robot.enumeration.Position;
import org.usfirst.frc.team3695.robot.util.Util;
import org.usfirst.frc.team3695.robot.util.Xbox;

/** the output/input setup */
public class OI {
	
	public static final Joystick DRIVER = new Joystick(0);
	public static final Joystick OPERATOR = new Joystick(1);
	
	/** 
	 * assigns what every SmartDash and controller button does
	 * 
	 * ye() gets called at teleop enable, assigning button values to controller input
	 * still in ye(), below controller value assigns, place each SmartDash button
	 * */
	public OI() {
		/// manipulator clamp
			Button toggleClamp = new JoystickButton(OPERATOR, Xbox.A);
				toggleClamp.toggleWhenActive(new ButtonCommandClamp());
		/// candy cane
			Button toggleHook = new JoystickButton(OPERATOR, Xbox.B);
				toggleHook.toggleWhenActive(new ButtonCommandHook());
			//Button dropIt = new JoystickButton(OPERATOR, Xbox.X);
				//dropIt.whenPressed(new ButtonCommandHitTheDeck());
		/// Reversing mode
			Button toggleReverse = new JoystickButton(DRIVER, Xbox.Y);
				toggleReverse.toggleWhenPressed(new ButtonCommandReverse());
		/// Docking mode
			Button toggleDock = new JoystickButton(DRIVER, Xbox.X);
				toggleDock.toggleWhenPressed(new ButtonCommandDock());
		/// To Compress, or Not To Compress. It is now an option.
			SmartDashboard.putData("Disable Compressor", new ButtonCommandKillCompressor());

		/// PID
			SmartDashboard.putData("Kill PID", new ButtonCommandKillPID());
			SmartDashboard.putNumber("Right Encoder Position", 0);
			SmartDashboard.putNumber("Left Encoder Position", 0);
			
		/// limit switch displays
			SmartDashboard.putBoolean("Lower Screw", true);
	    	SmartDashboard.putBoolean("Mid Position", false);
	    	SmartDashboard.putBoolean("Upper Screw", false);
	    	SmartDashboard.putBoolean("Lower Pinion", true);
	    	SmartDashboard.putBoolean("Upper Pinion", false);
	    	
	    	SmartDashboard.putNumber("Left inches", 0);
	    	SmartDashboard.putNumber("Right inches", 0);
	    	
	    	DriverStation.reportWarning("OI IS INSTANTIATED", false);

	    /// Cyborg command buttons
			SmartDashboard.putData("Drive Direct", new CyborgCommandDriveDirect(Util.getAndSetDouble("Drive Direct Power", 0)));
			SmartDashboard.putData("Drive Distance", new CyborgCommandDriveDistance(Util.getAndSetDouble("Drive Distance Inches", 0)));
			SmartDashboard.putData("Drive Until Error", new CyborgCommandDriveUntilError());
			SmartDashboard.putData("Rotate Degree", new CyborgCommandRotateDegrees(Util.getAndSetDouble("Rotate Degrees", 0)));
	}
	
}