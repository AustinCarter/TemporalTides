package temporalTides.playerStates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import temporalTides.controller.KeyController;
import temporalTides.controller.MouseController;
import temporalTides.controller.Resources;
import temporalTides.main.Title;
import temporalTides.map.Tile;
import temporalTides.sprite.Animation;
import temporalTides.sprite.Attack;
import temporalTides.sprite.Enemy;
import temporalTides.sprite.Player;


public abstract class PlayerState 
{	
	Player player;
	
	protected boolean airborne = false;
	protected boolean delayDamage = false;
	protected final int DELAYTIME = 10;//amount of invincible ticks the player gets after being damaged
	protected int delayed = 0;//the current amount of ticks that have passed since damage was last taken
	
	protected double gravity = .2;
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)(player.getX()  - player.getWidth() / 2),(int)(player.getY()  - player.getHeight() / 2),player.getWidth(),player.getHeight());
	}	
	
	public void draw(Graphics2D g)
	{
		g.setColor(Color.CYAN);
		//g.drawImage(playre.getAnimation.getImage(),(int)(player.getX()  - player.getWidth() / 2),(int)(player.getY()  - player.getHeight() / 2),null);		
	}
	
	public boolean collide(Attack a)
	{
		boolean hit = this.getBounds().intersects(a.getBounds());
		
		if(hit)
		{
			player.setHealth(player.getHealth() - a.getDamage());
		}
					
		return hit;		
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
				player.setVy(0);
				if(player.getY() < tile.getY())
				{
					dy  *= -1;
					this.land();
				}
			}
			else // horizontal
			{
				dx = box.width;
				if(player.getX() < tile.getX())
				{
					dx *= -1;
				}
				if(player.getVy() > 0)//Wall jump
					this.land();//Wall jump
			}
			player.translate(dx,dy);
		}
	}
	public void update()
	{
		if(MouseController.isPressed())
		{
			player.attack();
		}
		
		if(!KeyController.anyKeyDown() && !airborne)
		{
			player.getAnimation().setFrame(0);
		}
		else if(KeyController.isPressed(KeyController.RIGHT))
		{
			player.setAnimation(Resources.PLAYER_WALK[0]);
			player.setArmAnimation(Resources.PLAYER_ARM[0]);
			player.shift = 2;
		}
		else if(KeyController.isPressed(KeyController.LEFT))
		{
			player.setAnimation(Resources.PLAYER_WALK[1]);
			player.setArmAnimation(Resources.PLAYER_ARM[1]);
			player.shift = 13;
		}
		
		if(KeyController.isPressed(KeyController.Q))
		{
			player.setState(new DashState(player, 60));
			
		}
		if(KeyController.isDown(KeyController.LEFT))
		{
			player.getAnimation().update();
			player.setX(player.getX() - 5);
		}
		if(KeyController.isDown(KeyController.RIGHT))
		{
			player.getAnimation().update();
			player.setX(player.getX() + 5);
		}
		if(KeyController.isPressed(KeyController.UP) && !airborne)
		{
			 player.setVy(-5);;
			airborne = true;
		}
		
		
		else if(player.getY() > Title.HEIGHT - (50 + player.getHeight()))
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
		else if(player.getX() > Title.WIDTH)
			player.setX(Title.WIDTH);
		
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
	public void getDamage(Enemy e)
	{
		if(e.getBounds().intersects(this.getBounds()) && !delayDamage)
		{
			e.getAttack(player);
			delayDamage = true;
		}
	}
	
	public boolean getDelay()
	{
		return delayDamage;
	}
	
	public void land()
	{
		player.setVy(0);
		airborne = false;
	}

	
	
}
