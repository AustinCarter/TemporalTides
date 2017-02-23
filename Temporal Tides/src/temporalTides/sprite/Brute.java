package temporalTides.sprite;

import java.awt.Color;
import java.awt.Graphics2D;

public class Brute extends Enemy
{
	public Brute(double x, double y) 
	{
		super(x, y);
		height = 32;
		width = 16;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.MAGENTA);
		g.drawRect((int)x - height/2, (int)y - height/2, width, height);
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
