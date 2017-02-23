package temporalTides.controller;

import java.awt.event.KeyEvent;

public class KeyController
{

	public static final int NUM_KEYS = 8;
	
	public static boolean keys[] = new boolean[NUM_KEYS];
	public static boolean lastKeys[] = new boolean[NUM_KEYS];
	
	public static int UP = 0;
	public static int DOWN = 1;
	public static int LEFT = 2;
	public static int RIGHT = 3;
	public static int F = 4;
	public static int ENTER = 5;
	public static int ESCAPE = 6;
	public static int E = 7;
	
	public static void process(int i, boolean pressed)
	{
		switch(i)
		{
			case KeyEvent.VK_W:
				keys[UP] = pressed;
				break;
				
			case KeyEvent.VK_A:
				keys[LEFT] = pressed;
				break;
				
			case KeyEvent.VK_S:
				keys[DOWN] = pressed;
				break;
				
			case KeyEvent.VK_D:
				keys[RIGHT] = pressed;
				break;
			
			case KeyEvent.VK_F:
				keys[F] = pressed;
				break;
			
			case KeyEvent.VK_E:
				keys[E] = pressed;
				break;
				
			case KeyEvent.VK_ENTER:
				keys[ENTER] = pressed;
				break;
				
			case KeyEvent.VK_ESCAPE:
				keys[ESCAPE] = pressed;
				break;			
		}
		
		
		

	}
	
	public static void update() 
	{
		for(int i = 0; i < NUM_KEYS; i++)
		{
			lastKeys[i] = keys[i];
		}
	}
	
	public static boolean isPressed(int i)
	{
		return keys[i] && !lastKeys[i];
	}
	
	public static boolean isDown(int i)
	{
		return keys[i];
	}
	
	public static boolean anyKeyDown() 
	{
		for(int i = 0; i < NUM_KEYS; i++) 
			if(keys[i]) return true;

		return false;
	}
	
	public static boolean anyKeyPress() 
	{
		for(int i = 0; i < NUM_KEYS; i++) 
			if(keys[i] && !lastKeys[i])
				return true;

		return false;
	}
}
