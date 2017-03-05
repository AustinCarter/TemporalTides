package temporalTides.sprite;

import temporalTides.state.Play;

public abstract class Enemy extends Sprite
{
	Player target = Play.getPlayer();
	
	protected int damage;
	
	public Enemy(double x, double y) 
	{
		super(x, y);
	}
	
	public void getAttack(Player p)
	{
		p.health -= damage;
	}
	
	
	public void Update(){}

}
