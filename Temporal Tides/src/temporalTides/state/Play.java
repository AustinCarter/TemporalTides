package temporalTides.state;

import java.awt.Color;

import java.awt.Graphics2D;

import temporalTides.controller.KeyController;
import temporalTides.controller.StateController;
import temporalTides.main.Title;
import temporalTides.map.Map;
import temporalTides.sprite.Player;



public class Play extends State
{
	private Player player;
	private Map currentMap;
	
	
	public Play(StateController state)
	{
		super(state);
	}
	@Override
	public void init()
	{
		currentMap = new Map(); //TEMP CODE
		player = new Player(500,500);
		
	}

	@Override
	public void update() 
	{
		player.update();
		player.collide(currentMap.getRoom().getTiles());
		process();
		
	}

	@Override
	public void draw(Graphics2D g) 
	{
		player.draw(g);	
		currentMap.draw(g);
	}

	@Override
	public void process()
	{
		if(KeyController.isPressed(KeyController.ESCAPE))
			state.setState(state.MENU);
		
	}

}
