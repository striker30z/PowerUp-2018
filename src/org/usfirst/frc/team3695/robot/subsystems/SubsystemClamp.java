package org.usfirst.frc.team3695.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3695.robot.Constants;

/**
 * Controls the clamp on the arms of the manipulator
 */
public class SubsystemClamp extends Subsystem {
	private Solenoid openArms;
	private Solenoid closeArms;
	private boolean open; // current State of arms; true = open, false = closed
	
	public SubsystemClamp(){
		openArms = new Solenoid(Constants.OPEN_ARMS);
		closeArms = new Solenoid(Constants.CLOSE_ARMS);
		open = false;
	} 

    public void initDefaultCommand() {}

    //Open the manipulator
    public void openArms(){
    	openArms.set(true);
    	closeArms.set(false);
    	open = true;
    }

    //Close the manipulator
    public void closeArms(){
    	openArms.set(false);
    	closeArms.set(true);
    	open = false;
    }

    //Toggle the state of the manipulator
    public void toggleArms(){
    	if (open) closeArms();	else openArms();
    }
}

