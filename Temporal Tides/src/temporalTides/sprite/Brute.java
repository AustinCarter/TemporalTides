package temporalTides.sprite;

import java.awt.Color;
import java.awt.Graphics2D;

import temporalTides.controller.Resources;

public class Brute extends Enemy
{
	
	
	public Brute(double x, double y) 
	{
		super(x, y);
		damage = 5;
		health = 50;
		animation = new Animation();
		animation.setFrames(Resources.BRUTE[0]);
		height = animation.getHeight();
		width = animation.getWidth();
	}
	
	public void draw(Graphics2D g)
	{
		/*g.setColor(Color.MAGENTA);
		g.drawRect((int)(x - width/2), (int)(y - height/2), width, height);*/
		g.drawImage(animation.getImage(),(int)(x - width/2), (int)(y - height/2),null);
	}
	
	public void update()
	{
		
		super.update();
		
		if(this.x - target.x > 0)
		{
			x -= 1.5;
			
			if(animation.getFrames().equals(Resources.BRUTE[1]))
			{
				animation.setFrames(Resources.BRUTE[0]);
			}
		}
		else if(this.x - target.x < 0)
		{
			x += 1.5;
			
			if(animation.getFrames().equals(Resources.BRUTE[0]))
			{
				animation.setFrames(Resources.BRUTE[1]);
			}
		}
		
		
	}

}
