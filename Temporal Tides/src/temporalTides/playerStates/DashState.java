package temporalTides.playerStates;

import java.awt.Rectangle;

import temporalTides.controller.MouseController;
import temporalTides.sprite.Player;

public class DashState extends PlayerState
{
	private int UPDATES = 5;
	
	private double xDist, yDist;
	private int ups = 0;
	
	public DashState(Player player,  int distance)
	{
		this.player = player;
		
		double angle = Math.atan2(MouseController.mousex - player.getX(), MouseController.mousey - player.getY());
		
		xDist = distance * Math.cos((5 *Math.PI)/2 - angle);
		yDist = distance * Math.sin((5 *Math.PI)/2 - angle);
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)(player.getX()  - player.getWidth() / 2),(int)(player.getY()  - player.getHeight() / 2),0,0);
	}
	
	public void update()
	{						
		player.translate((int)xDist/5, (int)yDist/5);
		ups ++;
		
		if(ups >= UPDATES) player.setState(new GeneralState(player));
	}
	
}
