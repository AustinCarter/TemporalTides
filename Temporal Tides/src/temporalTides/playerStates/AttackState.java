package temporalTides.playerStates;


import temporalTides.main.Title;
import temporalTides.sprite.Attack;
import temporalTides.sprite.Player;

public class AttackState extends PlayerState
{
	Attack attack;
		
	public AttackState(Player player, Attack attack)
	{
		this.player = player;
		this.attack = attack;
	}
	

	@Override
	public void update() 
	{
		
		if(player.getY() > Title.HEIGHT - (50 + player.getHeight()))
		{
			player.setY( Title.HEIGHT - (50 + player.getHeight()));
			land();
		}
		
		player.setVy(player.getVy() + gravity);
		if(player.getVy() > 5) player.setVy(5); //terminal velocity
		
		player.setX(player.getX() + player.getVx());
		player.setY(player.getY() + player.getVy());
		
		if(player.getX() < 0)
			player.setX(0);
		if(player.getX() > Title.WIDTH)
			player.setX(Title.WIDTH);
		
		if(delayDamage && delayed > DELAYTIME)
		{
			delayDamage = false;
			delayed = 0;		
		}
		else if(delayDamage)
			delayed ++;
		
		for(Attack a : player.getAttacks())
			a.update();
		
		
	}
	

	

}
