package temporalTides.playerStates;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import temporalTides.sprite.Attack;
import temporalTides.sprite.Enemy;


public interface PlayerState 
{	
	public Rectangle getBounds();	
	public void draw(Graphics2D g);
	public boolean collide(Attack e);
	public void update();
	public void getDamage(Enemy e);
	public boolean getDelay();
	
	
}
