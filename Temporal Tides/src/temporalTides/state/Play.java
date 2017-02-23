package temporalTides.state;


import java.awt.Graphics2D;

import temporalTides.controller.KeyController;
import temporalTides.controller.StateController;
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
		player = new Player(50,520);
		
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
		if(KeyController.isPressed(KeyController.F) && currentMap.getRoomComplete())
		{
			currentMap.nextRoom();
			player.setPosition(50,520);
		}
		
	}

}
