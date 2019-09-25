import java.util.Scanner;

public class TerminalPlayer extends Player
{
	Scanner playerScanner;
	public TerminalPlayer ()
	{
		super("Avery the Local");
		playerScanner = new Scanner(System.in);
	}
	public TerminalPlayer (String name)
	{
		super(name);
		playerScanner = new Scanner(System.in);
	}
	
	//places ships based on a user's input
	void setupBoard()
	{
		Ship[] ships = {new Carrier(), new Battleship(), new Destroyer(), new Submarine(), new PatrolBoat()};
		for (Ship ship: ships)
		{
			while (true)
			{
				System.out.println("Which direction is your " + ship.name + " facing?\n0. North\n1. East\n2. South\n3. West");
				int orientation = playerScanner.nextInt();
				System.out.println("What are the x and y coordinates of the bow (front tip) of your " + ship.name + "?");
				if (board.placeShip(ship, playerScanner.nextInt(), playerScanner.nextInt(), orientation))
					break;
				System.out.println("Your ship can't fit there!");
			}
		}
	}
}
