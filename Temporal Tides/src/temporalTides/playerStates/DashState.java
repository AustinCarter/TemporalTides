package temporalTides.playerStates;

import java.awt.Rectangle;

import temporalTides.sprite.Player;

public class DashState extends PlayerState
{
	
	public DashState(Player player)
	{
		this.player = player;
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)(player.getX()  - player.getWidth() / 2),(int)(player.getY()  - player.getHeight() / 2),0,0);
	}
	
}
