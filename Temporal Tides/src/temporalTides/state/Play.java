package temporalTides.state;


import java.awt.Graphics2D;

import temporalTides.controller.KeyController;
import temporalTides.controller.StateController;
import temporalTides.map.Map;
import temporalTides.sprite.Brute;
import temporalTides.sprite.Enemy;
import temporalTides.sprite.Player;



public class Play extends State
{
	private static Player player;
	private Map currentMap;
	
	
	public Play(StateController state)
	{
		super(state);
	}
	@Override
	public void init()
	{
		player = new Player(50,520);
		currentMap = new Map(); //TEMP CODE
		
		
	}

	@Override
	public void update() 
	{
		player.update();
		for(Enemy e: currentMap.getEnemies())
		{
			e.update();
			e.collide(currentMap.getRoom().getTiles());
		}
		player.collide(currentMap.getRoom().getTiles());
		process();
		
	}

	@Override
	public void draw(Graphics2D g) 
	{
		player.draw(g);	
		currentMap.draw(g);
		for(Enemy e: currentMap.getEnemies())
		{
			e.draw(g);
		}
	}
	
	
	public static Player getPlayer()
	{
		return player;
	}

	@Override
	public void process()
	{
		if(KeyController.isPressed(KeyController.ESCAPE))
			state.setState(state.MENU);
		if(KeyController.isPressed(KeyController.F) && currentMap.getRoomComplete())
		{
			currentMap.nextRoom();
			player.setPosition(50,520);
		}
		
	}

}
