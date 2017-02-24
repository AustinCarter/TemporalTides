package temporalTides.playerStates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import temporalTides.controller.KeyController;
import temporalTides.controller.MouseController;
import temporalTides.main.Title;
import temporalTides.sprite.Attack;
import temporalTides.sprite.Enemy;
import temporalTides.sprite.Player;

public class AttackState implements PlayerState
{
	Player player;
	Attack attack;
	
	private boolean delayDamage = false;
	private final int DELAYTIME = 10;//amount of ticks that damage is delayed for
	private int delayed = 0;//the current amount of ticks that have passed since damage was last taken
	
	
	
	private double gravity = .2;
	public AttackState(Player player, Attack attack)
	{
		this.player = player;
		this.attack = attack;
	}
	
	@Override
	public Rectangle getBounds() 
	{
		return new Rectangle((int)(player.getX()  - player.getWidth() / 2),(int)(player.getY()  - player.getHeight() / 2),player.getWidth(),player.getHeight());
	}

	@Override
	public void draw(Graphics2D g) 
	{
		g.setColor(Color.CYAN);
		g.drawRect((int)(player.getX()  - player.getWidth() / 2),(int)(player.getY()  - player.getHeight() / 2),player.getWidth(),player.getHeight());		
	}

	@Override
	public boolean collide(Attack a) 
	{
		boolean hit = this.getBounds().intersects(a.getBounds());
		
		if(hit)
		{
			player.setHealth(player.getHealth() - a.getDamage());
		}
		
			
		return hit;	
	}

	@Override
	public void update() 
	{
		
		if(player.getY() > Title.HEIGHT - (50 + player.getHeight()))
		{
			player.setY( Title.HEIGHT - (50 + player.getHeight()));
			land();
		}
		
		player.setVy(player.getVy() + gravity);
		if(player.getVy() > 5) player.setVy(5); //terminal velocity
		
		player.setX(player.getX() + player.getVx());
		player.setY(player.getY() + player.getVy());
		
		if(player.getX() < 0)
			player.setX(0);
		if(player.getX() > 800)
			player.setX(800);
		
		if(delayDamage && delayed > DELAYTIME)
		{
			delayDamage = false;
			delayed = 0;		
		}
		else if(delayDamage)
			delayed ++;
		
		for(Attack a : player.getAttacks())
			a.update();
		
		
	}
	
	public void land()
	{
		player.setVy(0);
		player.airborne = false;
	}


	@Override
	public void getDamage(Enemy e)
	{
		if(e.getBounds().intersects(this.getBounds()) && !delayDamage)
		{
			e.getAttack(player);
			delayDamage = true;
		}		
	}

	@Override
	public boolean getDelay() 
	{
		return delayDamage;
	}

}
