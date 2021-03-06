package org.usfirst.frc.team3952.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;

public class DriveTrain {
	
	Joystick j;
	Talon leftDrive;
	Talon rightDrive;
	private RobotDrive rd;
	private double power;
	private double turnRate;
	private boolean flag;
	
	private boolean tflag;
	private long time;
	
	private int minus;
	private int switchx;
//	private boolean willStop;
	
	public DriveTrain(Joystick joyStick){
		tflag=false;
		j = joyStick;
		leftDrive = new Talon(0);
		rightDrive = new Talon(1);
		rd = new RobotDrive(leftDrive, rightDrive);
		power  = 1.0;//0.7
		turnRate = 1.1;//0.6
		switchx=1;
		//0.5 is regular
	}
	
	//below
	public void autonD(long start)
	{
		while(System.currentTimeMillis()-start<1500)
			rd.arcadeDrive(-0.9,0.0, true);
	}
	
	public void drive(){
		
		if(j.getRawButton(2))
		{
			switchx*=-1;
		}
		
		if(switchx==1)
		{
			if(j.getY()>0.3)
				{
					rd.arcadeDrive(j.getY()*power,j.getX()*turnRate,flag);
				}
			else
				rd.arcadeDrive(j.getY()*power, -j.getX()*turnRate, flag);
		}
		else
		{
			
			if(j.getY()>0.3)
				rd.arcadeDrive(-j.getY()*power,j.getX()*turnRate,flag);
			else
				rd.arcadeDrive(-j.getY()*power, -j.getX()*turnRate, flag);
				
		}
		
	}
	public boolean small(double x)
	{
		return Math.abs(x)<0.05;
	}
	public double getPower(){
		return power;
	}
	public double getTurnRate(){
		return turnRate;
	}
}
