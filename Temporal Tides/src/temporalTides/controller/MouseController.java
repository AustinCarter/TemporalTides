package temporalTides.controller;

public class MouseController
{
	public static double mousex;
	public static double mousey;
	
	public static boolean pressed;
	private static final int TICKS_TILL_HELD = 20; 
	private static int held;
	
	public static void update(double x, double y)
	{
		mousex = x;
		mousey = y;
		
		if(pressed) held++;
	}
	
	public static void process(boolean b)
	{
		pressed = b;
		held = 0;
	}
	
	public static boolean isPressed()
	{
		return pressed && held < 1;
	}
	
	public static boolean isHeld()
	{
		return held >= TICKS_TILL_HELD;
	}
	
}
