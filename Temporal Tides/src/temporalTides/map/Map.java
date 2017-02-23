package temporalTides.map;

import java.awt.Graphics2D;

import temporalTides.sprite.Sprite;

public class Map 
{
	private Room[] rooms;
	private int currentRoom;
	
	/*public Map(Room[] rooms, int startRoom)
	{
		this.rooms = rooms;
		this.currentRoom = startRoom;
	}*/
	
	public Map()
	{
		rooms = new Room[]{new Room()}; 
		currentRoom = 0;
	}
	
	public void setRoom(int i)
	{
		currentRoom = i;
	}
	
	public Room getRoom()
	{
		return this.rooms[currentRoom];
	}
	
	public void draw(Graphics2D g)
	{
		for(Tile t: rooms[currentRoom].getTiles())
		{
			t.draw(g);
		}
	}
	
}
