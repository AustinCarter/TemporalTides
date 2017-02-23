package temporalTides.sprite;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import temporalTides.main.Title;
import temporalTides.map.Tile;

public abstract class  Sprite
{
	protected int height;
	protected int width;
	
	protected double x;
	protected double y;	
	protected double vx = 0;
	protected double vy = 0;
	protected int health;
	
	protected double gravity = .2;
	
	protected Animation animation;
	protected int currentAnimation;
	
	
	public Sprite(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void collide(ArrayList<Tile> tiles)
	{
		for(Tile t: tiles)
		{
			this.collide(t);
		}
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
					//this.land();
				}
			}
			else // horizontal
			{
				dx = box.width;
				if(this.x < tile.getX())
				{
					dx *= -1;
				}
			}
			this.translate(dx,dy);
		}
	}
	
	public void update()
	{
		

		
		vy += gravity;
		if(vy > 5) vy = 5; //terminal velocity
		
		if(y > Title.HEIGHT - (50 + height))
		{
			y = Title.HEIGHT - (50 + height);
			vy = 0;
		}
		
		x += vx;
		y += vy;
		
		
		
		if(x < 0)
			x = 0;
		if(x > 800)
			x = 800;
	}
	
	public void setPosition(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void translate(int dx, int dy)
	{
		x += dx;
		y += dy;
	}

	
	public void setAnimation(Animation a)
	{
		animation = a;
	}
	
	public void setGravity(double d)
	{
		gravity = d;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)(x  - width / 2),(int)(y  - height / 2),width,height);
		
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void draw(Graphics2D g)
	{
		//g.drawImage(animation.getImage(),(int)(x  - width / 2),(int)(y  - height / 2),null);
		g.setColor(Color.CYAN);
		g.drawRect((int)(x  - width / 2),(int)(y  - height / 2),width,height);
	}
	
	
	
	

}
