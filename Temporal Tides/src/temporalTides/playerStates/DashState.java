package temporalTides.playerStates;

import java.awt.Rectangle;

import temporalTides.controller.MouseController;
import temporalTides.sprite.Player;

public class DashState extends PlayerState
{
	int xTar, yTar,distance,xUp,yUp;
	double angle;
	
	
	public DashState(Player player, int xTar, int yTar,int distance)
	{
		this.player = player;
		//player.setAnimation(Resources.PLAYER_DASH);
		this.xTar = xTar;
		this.yTar = yTar;
		
		this.distance = distance;
		
		angle = Math.atan2(MouseController.mousex - player.getX(), MouseController.mousey - player.getY());
		
		xTar = (int)(distance * Math.cos((5 *Math.PI)/2 - angle));
		yTar = (int)(distance * Math.sin((5 *Math.PI)/2 - angle));
		
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle((int)(player.getX()  - player.getWidth() / 2),(int)(player.getY()  - player.getHeight() / 2),0,0);
	}
	
	public void update()
	{
		 player.setX(player.getX() + xUp/4);
		 player.setY(player.getY() + yUp/4);
		 if(Math.abs(player.getX() - xTar)  <= 4 && Math.abs(player.getY() - yTar) <= 4)
			 player.setState(new GeneralState(player));
	}
	
	
}
