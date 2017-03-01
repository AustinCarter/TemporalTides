package temporalTides.sprite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import temporalTides.controller.MouseController;
import temporalTides.main.Title;

public class Attack 
{
	private int range;
	private double traveled;
	private double speed;
	private double xSpeed;
	private double ySpeed;
	
	private double width;
	private double height;
	
	private double x;
	private double y; 
	
	private double fireAngle;
	
	private boolean collided = false;
		
	Animation animation;
	Animation deathAnimation;
	
	protected int damage;
	
	public Attack(double x, double y, int dmg, int speed, int range)
	{
		this.speed = speed;
		this.damage = dmg;
		this.range = range;
		this.x = x;
		this.y = y;
		
		height = 8; //Temp Values
		width = 8;  //Temp Values
		init();
		
	}
	
	private void init()
	{
		fireAngle = Math.atan2(MouseController.mousex - x, MouseController.mousey - y);
		
		xSpeed = speed * Math.cos((5 *Math.PI)/2 - fireAngle);
		ySpeed = speed * Math.sin((5 *Math.PI)/2 - fireAngle);
	}
	
	public void update()
	{
		if(! collided)
		{
			x += xSpeed;
			y += ySpeed;
			traveled += speed;	
		}
			
		
	}
	
	public int getDamage(){collided = true; return damage;}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)(x - width/2), (int)(y - height/2),(int)height,(int)width);
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.MAGENTA);
		g.fillRect((int)(x - width/2), (int)(y - height/2),(int)height,(int)width);
	}
}
