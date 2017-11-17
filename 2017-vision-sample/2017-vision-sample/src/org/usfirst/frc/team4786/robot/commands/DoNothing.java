package org.usfirst.frc.team4786.robot.commands;

import org.usfirst.frc.team4786.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;


/**
 *
 */
public class DoNothing extends Command {
	
	
	
	NetworkTable myTable; // starts myTable (We think that you have to put this and make a table to access the data in all of the different places that you want the data to be used in (same for the myTable = one!))

	

    public DoNothing() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chasis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	        
    	myTable = NetworkTable.getTable("GRIP/myContoursReport"); // makes the table myTable properly what it should be
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//Vision Target Testing Below - LW
    	while (true) {
    	
    	double centerX = myTable.getNumber("centerX", 320); 
    	
    	//double centerXsSize = centerXs.length;
    	//double centerX = centerXs[0];
    	
    	
    		if (centerX > 340) {
    			
    			Robot.driveTrain.driveWithVelocityControl(0, 0.5);
    			
    		} else if (centerX < 300) {
    			
    			Robot.driveTrain.driveWithVelocityControl(0.5, 0);
    			
    		} else {
    			Robot.driveTrain.driveWithVelocityControl(0, 0);

    		}
    	}
    	
    	
    	
    	
    	
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
