package temporalTides.map;

import java.util.ArrayList;

public class Room 
{
	
	ArrayList<Tile> tiles = new ArrayList<>();
	
	
	public Room()
	{
		tiles.add(new Tile(200,200));
		tiles.add(new Tile(300,300));
		tiles.add(new Tile(700,500)); 
		tiles.add(new Tile(500,575));
	}
	
	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}
	
	public void loadRoom()
	{
		
	}
	
	public void readRoom()
	{
		
	}
}
