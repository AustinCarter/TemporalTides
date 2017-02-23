package temporalTides.state;

import java.awt.Graphics2D;

import temporalTides.controller.StateController;

public abstract class State 
{
	
	protected StateController state;
	
	public State(StateController state) 
	{
		this.state = state;
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void process();
	
}
