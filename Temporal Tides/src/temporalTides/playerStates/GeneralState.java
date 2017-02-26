package temporalTides.playerStates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import temporalTides.controller.KeyController;
import temporalTides.controller.MouseController;
import temporalTides.main.Title;
import temporalTides.map.Tile;
import temporalTides.sprite.Attack;
import temporalTides.sprite.Enemy;
import temporalTides.sprite.Player;

public class GeneralState extends PlayerState
{
	
	public GeneralState(Player player)
	{
		this.player = player;
	}
	

}
