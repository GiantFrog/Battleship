import java.util.ArrayList;
import java.util.Arrays;

public class Board
{
	private int height = 10, width = 10;
	private Player player;
	ArrayList<Ship> ships;
	private boolean[][] shotAt;
	private char[][] occupied;
	
	public Board (Player player)
	{
		this.player = player;
		player.board = this;
		ships = new ArrayList<>();
		occupied = new char[width][height];
		for (char[] row: occupied)
			Arrays.fill(row, '~');
		shotAt = new boolean[width][height];	//this should set every value to false by default.
	}
	
	//returns true if the ship was successfully added to the board at that location
	public boolean placeShip (Ship ship, int bowX, int bowY, int orientation)
	{
		//calculate where the back tip of the ship is given the front, size, and orientation
		int sternX, sternY;
		switch (orientation)
		{
			case 0:	//facing north
				sternX = bowX;
				sternY = bowY + ship.size - 1;
				break;
			case 1:	//facing east
				sternX = bowX - ship.size + 1;
				sternY = bowY;
				break;
			case 2:	//facing south
				sternX = bowX;
				sternY = bowY - ship.size + 1;
				break;
			case 3:	//facing west
				sternX = bowX + ship.size - 1;
				sternY = bowY;
				break;
			default:
				System.out.println("This ship's orientation is neither north, south, east, nor west. :(");
				sternX = sternY = 0;
		}
		
		//verify this type of ship has not yet been placed
		for (Ship gravyBoat: ships)
		{
			if (gravyBoat.getClass().equals(ship.getClass()))
				return false;
		}
		
		//verify the tips of the ship are in bounds
		if (bowX < 0 || bowY < 0 || sternX < 0 || sternY < 0 || bowX >= width || bowY >= height || sternX >= width || sternY >= height)
			return false;
		
		//verify the ship does not overlap any part of another
		int counter;
		switch (orientation)
		{
			case 0:	//facing north
				counter = bowY;
				while (counter < sternY)
				{
					if (occupied[bowX][counter] != '~')
						return false;
					counter++;
				}
				break;
			case 1:	//facing east
				counter = bowX;
				while (counter > sternX)
				{
					if (occupied[counter][bowY] != '~')
						return false;
					counter--;
				}
				break;
			case 2:	//facing south
				counter = bowY;
				while (counter > sternY)
				{
					if (occupied[bowX][counter] != '~')
						return false;
					counter--;
				}
				break;
			case 3:	//facing west
				counter = bowX;
				while (counter < sternX)
				{
					if (occupied[counter][bowY] != '~')
						return false;
					counter++;
				}
				break;
		}
		
		//verify the distance between the tips of the ship math the ship's actual length
		if (Math.abs((bowX - sternX) + (bowY - sternY)) != ship.size - 1)
			return false;
		
		//the ship can be placed! Let's tell it its new coordinates and mark its location as occupied.
		switch (orientation)
		{
			case 0:	//facing north
				counter = bowY;
				while (counter < sternY)
				{
					occupied[bowX][counter] = ship.character;
					counter++;
				}
				break;
			case 1:	//facing east
				counter = bowX;
				while (counter > sternX)
				{
					occupied[counter][bowY] = ship.character;
					counter--;
				}
				break;
			case 2:	//facing south
				counter = bowY;
				while (counter > sternY)
				{
					occupied[bowX][counter] = ship.character;
					counter--;
				}
				break;
			case 3:	//facing west
				counter = bowX;
				while (counter < sternX)
				{
					occupied[counter][bowY] = ship.character;
					counter++;
				}
				break;
		}
		ship.setLocation(bowX, bowY, sternX, sternY, orientation);
		return true;
	}
	
	//call when local player takes fire from the opponent. returns true if a ship is hit. marks the space as shotAt.
	public boolean takeShot (int x, int y)
	{
		shotAt[x][y] = true;
		if (occupied[x][y] != '~')
			return true;
		//TODO get ship at that coordinate? inform the ship it has been damaged?
		return false;
	}
	
	//call wasHit when local player fires a shot and the opponent tells you it was a hit. wasMissed for missed shots.
	public void wasHit (int x, int y)
	{
		shotAt[x][y] = true;
		occupied[x][y] = 'O';
	}
	public void wasMissed (int x, int y)
	{
		shotAt[x][y] = true;
	}
}
