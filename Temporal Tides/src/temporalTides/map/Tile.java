package temporalTides.map;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Tile 
{
	private int x;
	private int y;
	
	private int height;
	private int width;
	
	private BufferedImage image;
	
	public Tile (int x, int y)
	{
		this.x = x;
		this.y = y;
		width = 16;
		height = 16;
	}
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.RED);
		g.drawRect(this.x - width/2,this.y -height/2 , width,height);
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(this.x - 8,this.y -8 , 16,16);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	
}
