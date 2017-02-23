package temporalTides.state;

import java.awt.Graphics2D;


import temporalTides.controller.StateController;
import temporalTides.main.Title;
import temporalTides.controller.KeyController;

public class Pause  extends State
{
	public Pause(StateController state)
	{
		super(state);
	}

	@Override
	public void init(){}

	@Override
	public void update()
	{
		process();
		
	}

	@Override
	public void draw(Graphics2D g) 
	{
		g.drawString("Paused",Title.WIDTH/2,Title.HEIGHT/2);
		
	}

	@Override
	public void process()
	{
		if(KeyController.isPressed(KeyController.ESCAPE))
		{
			state.setPaused(false);
			//JukeBox.resumeLoop("music1");
		}
		
	}

}
