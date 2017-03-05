package temporalTides.sprite;

import java.awt.Color;
import java.awt.Graphics2D;

import temporalTides.controller.Resources;

public class Brute extends Enemy
{
	
	public Brute(double x, double y) 
	{
		super(x, y);
		height = 32;
		width = 16;
		damage = 5;
		health = 50;
		animation = new Animation();
		animation.setFrames(Resources.BRUTE[0]);
	}
	
	public void draw(Graphics2D g)
	{
		/*g.setColor(Color.MAGENTA);
		g.drawRect((int)(x - width/2), (int)(y - height/2), width, height);*/
		g.drawImage(animation.getImage(),(int)(x - width/2), (int)(y - height/2),null);
	}
	
	public void update()
	{
		if(this.x - target.x > 2.5)
			x -= 1.5;
		else if(this.x - target.x < -2.5)
			x += 1.5;
		
		super.update();
		
		
	}

}
