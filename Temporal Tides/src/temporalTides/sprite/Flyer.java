package temporalTides.sprite;

import java.awt.Color;
import java.awt.Graphics2D;

public class Flyer extends Enemy 
{
	
	public Flyer(double x, double y) 
	{
		super(x, y);
		//gravity = 0;
		height = 16;
		width = 16;
	}
	
	public void update()
	{
		if(this.x - target.x > 2.5)
			x -= 1.5;
		else if(this.x - target.x < -2.5)
			x += 1.5;
		
		if(this.y - target.y > 2.5)
			y -= 1.5;
		else if(this.y - target.y < -2.5)
			y += 1.5;
		
		
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.ORANGE);
		
		g.drawRect((int)(x - width/2),(int)(y - height/2),width,height);
	}
}
