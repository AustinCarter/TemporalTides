package temporalTides.sprite;

import java.awt.Rectangle;

import temporalTides.controller.KeyController;
import temporalTides.main.Title;
import temporalTides.map.Tile;

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
	
	public void collide(Tile tile)
	{
		Rectangle pbound = this.getBounds(),
				  tbound = tile.getBounds();
		if(pbound.intersects(tbound)) // collision!!!!
		{
			int dx = 0, dy = 0;
			Rectangle box = pbound.intersection(tbound);
			if(box.width > box.height) // vertical collision
			{
				dy = box.height;
				this.vy = 0;
				if(this.y < tile.getY())
				{
					dy  *= -1;
					this.land();
				}
			}
			else // horizontal
			{
				dx = box.width;
				if(this.x < tile.getX())
				{
					dx *= -1;
				}
				
				/*vy = 0;                             Wall Jump attempt, Sticks to walls :/
				this.land();*/
			}
			this.translate(dx,dy);
		}
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
		
		if(x < 0)
			x = 0;
		if(x > 800)
			x = 800;
		
		
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
