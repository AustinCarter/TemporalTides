package temporalTides.state;

import java.awt.Graphics2D;

import temporalTides.controller.KeyController;
import temporalTides.controller.StateController;
import temporalTides.main.Title;

public class Menu extends State
{
	
	private int selected;
	private String[] options = {
			"Start",
			"Deuces"
	};
	
	public Menu (StateController state)
	{
		super(state);
	}
	@Override
	public void init()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update()
	{
		process();
		
	}

	@Override
	public void draw(Graphics2D g) 
	{
		g.drawString("I Love Menues", Title.WIDTH/2, Title.HEIGHT/2);
		g.drawString("" + selected + ": " + options[selected], Title.WIDTH/2, Title.HEIGHT/2 + 50);
		
	}

	@Override
	public void process() 
	{
		if(KeyController.isPressed(KeyController.DOWN)) {
			//JukeBox.play("menuoption");
			selected++;
			
			if(selected >= options.length)
				selected = 0;
		}
		if(KeyController.isPressed(KeyController.UP) ) {
			//JukeBox.play("menuoption");
			selected--;
			
			if(selected < 0)
				selected = options.length - 1;
		}
		if(KeyController.isPressed(KeyController.ENTER)) {
			//JukeBox.play("collect");
			selectOption();
		}
	}
	
	private void selectOption() {
		
		if(selected == 0) 
		{
			state.setState(StateController.PLAY);
		}
		if(selected == 1) 
		{
			System.exit(0);
		}
	}

}
