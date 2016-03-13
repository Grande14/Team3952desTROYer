package org.usfirst.frc.team3952.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class WindshieldMotor {

	Talon t;
	Talon t2;
	int channel;
	int channel2;
	Joystick j;
	JoystickButton b3,b4;
	public WindshieldMotor(int channelx, int channel2x,Joystick jx)
	{
		channel=channelx;
		channel2=channel2x;
		t=new Talon(channel);
		t2=new Talon(channel2);
		j=jx;
		b3=new JoystickButton(j,3);
		b4=new JoystickButton(j,4);
		
		b3.whileHeld(new do3c(t,t2));
		b4.whileHeld(new do4c(t,t2));
	}
	
}