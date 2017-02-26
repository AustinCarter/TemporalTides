package temporalTides.sprite;


import java.awt.Graphics2D;
import java.awt.Rectangle;

import temporalTides.map.Tile;
import temporalTides.playerStates.*;

public class Player extends Sprite
{

	/*private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;*/
	
	public boolean airborne = false;
	
	PlayerState state;
	
	
	public Player(double x, double y) 
	{
		super(x, y);
		height = 32;
		width = 16;
		health = 100;
		state = new GeneralState(this);
	}
	
	public boolean collide(Attack a) {return 	state.collide(a);}
	
	public Rectangle getBounds() {return state.getBounds();}
	
	
	public void collide(Tile tile)
	{
		state.collide(tile);
	}
	
	
	public void update() {state.update();}
	
	public void setState(PlayerState state)
	{
		this.state = state;
	}
	
	public void getDamage(Enemy e){state.getDamage(e);}
	
	public void land()
	{
		vy = 0;
		airborne = false;
	}
	
	public void draw(Graphics2D g)
	{
		state.draw(g);
		
		for(Attack a: myAttacks)
			a.draw(g);
	}
		
			
	public boolean getDelay(){return state.getDelay();}
	
	
	
}
