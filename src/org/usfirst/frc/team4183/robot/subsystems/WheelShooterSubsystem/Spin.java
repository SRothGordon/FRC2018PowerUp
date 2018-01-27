package org.usfirst.frc.team4183.robot.subsystems.WheelShooterSubsystem;

import org.usfirst.frc.team4183.robot.Robot;
import org.usfirst.frc.team4183.utils.CommandUtils;
import org.usfirst.frc.team4183.robot.OI;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Spin extends Command 
{

    public Spin() 
    {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.wheelShooterSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	Robot.wheelShooterSubsystem.disable();
    

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      //System.out.println("Im Waiting");

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
    	if (Robot.wheelShooterSubsystem.isPresent())
    	{
	    	/// TODO: Resurrect this from last year
	    	if(Robot.oi.btnShooter.get()) {
	    		return CommandUtils.stateChange(this, new Shooting());
	        }
    	}
    	
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
