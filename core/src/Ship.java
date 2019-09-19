public abstract class Ship
{
	int size, bowX, bowY, sternX, sternY;
	
	public int getSize()
	{
		return size;
	}
	
	//sets the ship's coordinates.
	//should only be called by Board.placeShip(), which will verify the coordinates are valid.
	public void setLocation (int bowX, int bowY, int sternX, int sternY)
	{
		this.bowX = bowX;
		this.bowY = bowY;
		this.sternX = sternX;
		this.sternY = sternY;
	}
}
