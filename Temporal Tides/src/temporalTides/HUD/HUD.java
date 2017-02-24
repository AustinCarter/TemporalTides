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
		
		int translate = 128 + 64;
		
		g.fillRect(16 + translate - 48, Title.HEIGHT - 48, 256, 32);
		
		g.drawRect(288 + translate,Title.HEIGHT - 48, 32, 32);
		g.drawRect(336 + translate,Title.HEIGHT - 48, 32, 32);
		g.drawRect(384 + translate,Title.HEIGHT - 48, 32, 32);
		g.drawRect(432 + translate,Title.HEIGHT - 48, 32, 32);
		
		//g.drawString("" + MouseController.mousex + "," + MouseController.mousey, 20, 20);
		//g.drawString("Pressed: " + MouseController.isPressed() + " Held:" + MouseController.isHeld() , 20, 40);
	}
	
	public void init()
	{
		
	}

}
