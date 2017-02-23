package temporalTides.HUD;

import java.awt.Color;
import java.awt.Graphics2D;

import temporalTides.controller.MouseController;
import temporalTides.main.Title;
import temporalTides.sprite.Player;

public class HUD 
{
	Player player;
	private int health;
	
	public HUD(Player p)
	{
		player = p;
		init();
	}
	
	public void update()
	{
		health = player.getHealth();
	}
	
	public void draw(Graphics2D g)
	{
		if(!player.getDelay())
			g.setColor(Color.GREEN);
		else
			g.setColor(Color.ORANGE);
		
		g.fillRect(20, Title.BAR_HEIGHT - 60, health, 20);
		
		g.drawString("" + MouseController.mousex + "," + MouseController.mousey, 20, 20);
		g.drawString("Pressed: " + MouseController.isPressed() + " Held:" + MouseController.isHeld() , 20, 40);
	}
	
	public void init()
	{
		
	}

}
