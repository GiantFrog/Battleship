import java.util.ArrayList;

public class Board
{
	private int height = 10, width = 10;
	private Player player;
	ArrayList<Ship> ships;
	
	public Board (Player player)
	{
		this.player = player;
		player.board = this;
		ships = new ArrayList<>();
	}
	
	//returns true if the ship was successfully added to the board at that location
	public boolean placeShip (Ship ship, int bowX, int bowY, int sternX, int sternY)
	{
		//verify this type of ship has not yet been placed
		for (Ship gravyBoat: ships)
		{
			if (gravyBoat.getClass().equals(ship.getClass()))
				return false;
		}
		
		//TODO verify the ship won't overlap another and the distance between tips matches the ship length.
		//verify the tips of the ship are in bounds
		if (bowX < 0 || bowY < 0 || sternX < 0 || sternY < 0 || bowX >= width || bowY >= height || sternX >= width || sternY >= height)
			return false;
		
		//verify the ship does not overlap any part of another
		
		//verify the distance between the tips of the ship math the ship's actual length
		
		ship.setLocation(bowX, bowY, sternX, sternY);
		return true;
	}
}
