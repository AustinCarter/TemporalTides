// The GameStateManager does exactly what its
// name says. It contains a list of GameStates.
// It decides which GameState to update() and
// draw() and handles switching between different
// GameStates.

package temporalTides.controller;

import java.awt.Graphics2D;

import temporalTides.state.*;



public class StateController 
{
	
	private boolean paused;
	private Pause pause = new Pause(this);
	
	private State[] states;
	private int currentState;
	private int previousState;
	
	public static final int NUM_STATES = 3;
	public static final int LOAD = 0;
	public static final int MENU = 1;
	public static final int PLAY = 2;
	//public static final int SHOP = 3;
	//public static final int END_ROOM = 4;
	
	public StateController() 
	{
		
		//JukeBox.init();
		
		paused = false;
		pause = new Pause(this);
		
		states = new State[NUM_STATES];
		setState(PLAY);
		
	}
	
	public void setState(int i) 
	{
		previousState = currentState;
		unloadState(previousState);
		currentState = i;
		if(i == LOAD)
		{
			states[i] = new Load(this);
			states[i].init();
		}
		else if(i == MENU)
		{
			states[i] = new Menu(this);
			states[i].init();
		}
		else if(i == PLAY) 
		{
			states[i] = new Play(this);
			states[i].init();
		}
		/*else if(i == SHOP) 
		{
			states[i] = new Shop(this);
			states[i].init();
		}
		else if(i == END_ROOM)
		{
			states[i] = new EndRoom(this);
			states[i].init();
		}*/
	}
	
	public void unloadState(int i) 
	{
		states[i] = null;
	}
	
	public void setPaused(boolean b)
	{
		paused = b;
	}
	
	public void update() 
	{
		if(paused) 
		{
			pause.update();
		}
		else if(states[currentState] != null)
		{
			states[currentState].update();
		}
	}
	
	public void draw(Graphics2D g) 
	{
		if(paused) 
		{
			pause.draw(g);
		}
		else if(states[currentState] != null) 
		{
			states[currentState].draw(g);
		}
	}
	
}
