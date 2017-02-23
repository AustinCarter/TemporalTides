package temporalTides.sprite;

import temporalTides.controller.KeyController;
import temporalTides.main.Title;

public class Player extends Sprite
{

	/*private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;*/
	private boolean airborne = false;
	
	
	public Player(double x, double y) 
	{
		super(x, y);
		height = 32;
		width = 16;
	}
	
	
	
	public void update()
	{
		
		
		if(KeyController.isDown(KeyController.LEFT))
		{
			x -= 5;
		}
		if(KeyController.isDown(KeyController.RIGHT))
		{
			x += 5;
		}
		if(KeyController.isPressed(KeyController.UP) && !airborne)
		{
			vy -= 5;
			airborne = true;
		}
		
		else if(y > Title.HEIGHT - (50 + height))
		{
			y = Title.HEIGHT - (50 + height);
			land();
		}
		
		vy += gravity;
		if(vy > 5) vy = 5; //terminal velocity
		x += vx;
		y += vy;
		/*if(down)
		{
			
		}*/
	}
	
	public void land()
	{
		vy = 0;
		airborne = false;
	}
	
	/*public void setLeft(boolean b)
	{
		left = b;
	}
	public void setRight(boolean b)
	{
		right = b;
	}
	public void setUp(boolean b)
	{
		up = b;
	}
	public void setDown(boolean b)
	{
		down = b;
	}*/
	
	
}
