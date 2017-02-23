package temporalTides.map;

import java.util.ArrayList;

public class Room 
{
	
	ArrayList<Tile> tiles = new ArrayList<>();
	
	boolean cleared = true;
	
	
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
		}
		else
		{
			tiles.add(new Tile(100,123));
			tiles.add(new Tile(525,525));
			tiles.add(new Tile(234,234));
			tiles.add(new Tile(456,456));
		}
	
	}
	
	
	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}
	
	
	public boolean checkComplete()
	{
		// TODO check that the room is completed
		return cleared;
	}
	
	
	
	public void loadRoom()
	{
		
	}
	
	public void readRoom()
	{
		
	}
}
