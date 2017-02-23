package temporalTides.map;

import java.awt.Graphics2D;

import temporalTides.main.Title;
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
		rooms = new Room[]{new Room(1),new Room(0)}; 
		currentRoom = 0;
	}
	
	public void nextRoom()
	{
		currentRoom = currentRoom + 1;
		if(currentRoom >= rooms.length) currentRoom = 0; //TEMP: handle outOfBounds until map-changing/end screens are handled
		
	}
	
	public void setRoom(int i)
	{
		currentRoom = i;
	}
	
	public Room getRoom()
	{
		return this.rooms[currentRoom];
	}
	
	public boolean getRoomComplete()
	{
		return rooms[currentRoom].checkComplete();
	}
	
	public void draw(Graphics2D g)
	{
		for(Tile t: rooms[currentRoom].getTiles())
		{
			t.draw(g);
		}
		
		if(rooms[currentRoom].checkComplete())
			g.drawString("Level Complete",Title.WIDTH/2,Title.HEIGHT/2);
	}
	
}
