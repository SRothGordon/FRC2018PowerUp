package org.usfirst.frc.team4183.robot.subsystems.IntakeSubsystem;

import org.usfirst.frc.team4183.robot.Robot;
import org.usfirst.frc.team4183.utils.CommandUtils;
import org.usfirst.frc.team4183.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakingOpen extends Command {

    public IntakingOpen() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    		requires(Robot.intakeSubsystem);	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    Robot.intakeSubsystem.opengate();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    //	Robot.intakeSubsystem.setMotorSpeed(SmartDashboard.getNumber("Shooting Speed", 0));
    	Robot.intakeSubsystem.setMotorSpeed(-0.5);
    	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if (Robot.intakeSubsystem.getCurrLimitStatus())
    	{
    	if(timeSinceInitialized()-Robot.intakeSubsystem.getTimeCurrentLimit() > .3 && timeSinceInitialized()-Robot.intakeSubsystem.getTimeCurrentLimit() < 2) {
    		return CommandUtils.stateChange(this, new CurrentLimit());
    	}
    	}
    	if( Robot.oi.btnIdle.get()) {
    		return CommandUtils.stateChange(this, new Deployed());
    	}
    	if( ! Robot.oi.btnOpenGate.get()) {
    		return CommandUtils.stateChange(this , new Deployed());
    	}
    	if (Robot.oi.btnRotateCube.get())
    	{
    		return CommandUtils.stateChange(this, new IntakeRotate());
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
