package temporalTides.map;

import java.util.ArrayList;

import temporalTides.sprite.Brute;
import temporalTides.sprite.Enemy;
import temporalTides.sprite.Flyer;

public class Room 
{
	
	ArrayList<Tile> tiles = new ArrayList<>();
	ArrayList<Enemy> enemies= new ArrayList<>();
	
	
	//boolean cleared = true;
	
	//temporary constructors 
	public Room()
	{
		tiles.add(new Tile(200,200));
		tiles.add(new Tile(300,300));
		tiles.add(new Tile(700,500)); 
		tiles.add(new Tile(500,575));
	}
	public Room(int i)
	{
		if(i == 0)
		{
			tiles.add(new Tile(200,200));
			tiles.add(new Tile(300,300));
			tiles.add(new Tile(700,500)); 
			tiles.add(new Tile(500,575));
			
			enemies.add(new Brute(550,520));
			enemies.add(new Flyer(200,200));
		}
		else
		{
			tiles.add(new Tile(100,123));
			tiles.add(new Tile(525,525));
			tiles.add(new Tile(525,525 - 64));
			tiles.add(new Tile(525,525 - 48));
			tiles.add(new Tile(525,525 - 32));
			tiles.add(new Tile(525,525 - 16));
			tiles.add(new Tile(525,525 + 16));
			tiles.add(new Tile(525,525 + 32));
			tiles.add(new Tile(234,234));
			tiles.add(new Tile(456,456));
			
			enemies.add(new Brute(550,520));
			enemies.add(new Brute(500,520));
		}
	
	}
	
	public ArrayList<Enemy> getEnemies()
	{
		return enemies;
	}
	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}
	
	
	public boolean checkComplete()
	{
		// TODO check that the room is completed
		return enemies.size() == 0;
	}
	
	
	
	public void loadRoom()
	{
		
	}
	
	public void readRoom()
	{
		
	}
}
