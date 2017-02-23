package temporalTides.state;


import java.awt.Graphics2D;

import temporalTides.controller.KeyController;
import temporalTides.controller.StateController;
import temporalTides.map.Map;
import temporalTides.sprite.Brute;
import temporalTides.sprite.Player;



public class Play extends State
{
	private static Player player;
	private Map currentMap;
	private Brute enemy;
	
	
	public Play(StateController state)
	{
		super(state);
	}
	@Override
	public void init()
	{
		currentMap = new Map(); //TEMP CODE
		player = new Player(50,520);
		enemy = new Brute(550,520);
		
	}

	@Override
	public void update() 
	{
		player.update();
		enemy.update();
		enemy.collide(currentMap.getRoom().getTiles());
		player.collide(currentMap.getRoom().getTiles());
		process();
		
	}

	@Override
	public void draw(Graphics2D g) 
	{
		player.draw(g);	
		currentMap.draw(g);
		enemy.draw(g);
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
