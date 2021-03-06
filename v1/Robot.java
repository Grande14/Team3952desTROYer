package org.usfirst.frc.team3952.robot;

import java.io.IOException; 

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot; 
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	DriveTrain dt;
	DashBoard board;
	Joystick stick;
	LinearActuatorWinch lin;	
	//ImageProcess i;
	int autoLoopCounter;
	
	ServoC sc;
	//WindshieldMotor m1,m2;
	//we are using talon motors so need to make new DriveTrain class
	
    /**
     * This function is run when the robot is first started up and should be;ioj;oi
     * used for any initialization code.
     */
    public void robotInit() {
    	board = new DashBoard();
    	stick = new Joystick(0);
    	dt=new DriveTrain(stick);
    	lin =new LinearActuatorWinch(stick);
    	
    	sc=new ServoC(stick);
    	//m1=new WindshieldMotor(4,stick);
    	//m2=new WindshieldMotor(5,stick);
    	
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	dt.autonD();
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	dt.drive();
    	board.updateDashboard();
    	lin.goLAW();
    	
    	sc.pCheck();
    	//m1.pressCheck();
    	//m2.pressCheck();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
}
