public class TestPlayer extends Player
{
	public TestPlayer()
	{
		super("Jesse the Fool");
		setupBoard();
	}
	public TestPlayer (String name)
	{
		super(name);
		setupBoard();
	}
	
	void setupBoard ()
	{
		board.placeShip(new Carrier(), 0, 0, 0);
		board.placeShip(new Battleship(), 1, 0, 0);
		board.placeShip(new Destroyer(), 2, 0, 0);
		board.placeShip(new Submarine(), 3, 0, 0);
		board.placeShip(new PatrolBoat(), 4, 4, 3);
	}
}
