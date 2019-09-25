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
		//TODO less copy/paste
		while (true)
		{
			System.out.println("Which direction is your carrier facing?\n0. North\n1. East\n2. South\n3. West");
			int orientation = playerScanner.nextInt();
			System.out.println("What are the x and y coordinates of the bow (front tip) of your carrier?");
			if (board.placeShip(new Carrier(), playerScanner.nextInt(), playerScanner.nextInt(), orientation))
				break;
			System.out.println("Your ship can't fit there!");
		}
		while (true)
		{
			System.out.println("Which direction is your battleship facing?\n0. North\n1. East\n2. South\n3. West");
			int orientation = playerScanner.nextInt();
			System.out.println("What are the x and y coordinates of the bow (front tip) of your battleship?");
			if (board.placeShip(new Battleship(), playerScanner.nextInt(), playerScanner.nextInt(), orientation))
				break;
			System.out.println("Your ship can't fit there!");
		}
		while (true)
		{
			System.out.println("Which direction is your destroyer facing?\n0. North\n1. East\n2. South\n3. West");
			int orientation = playerScanner.nextInt();
			System.out.println("What are the x and y coordinates of the bow (front tip) of your destroyer?");
			if (board.placeShip(new Destroyer(), playerScanner.nextInt(), playerScanner.nextInt(), orientation))
				break;
			System.out.println("Your ship can't fit there!");
		}
		while (true)
		{
			System.out.println("Which direction is your submarine facing?\n0. North\n1. East\n2. South\n3. West");
			int orientation = playerScanner.nextInt();
			System.out.println("What are the x and y coordinates of the bow (front tip) of your submarine?");
			if (board.placeShip(new Submarine(), playerScanner.nextInt(), playerScanner.nextInt(), orientation))
				break;
			System.out.println("Your ship can't fit there!");
		}
		while (true)
		{
			System.out.println("Which direction is your patrol boat facing?\n0. North\n1. East\n2. South\n3. West");
			int orientation = playerScanner.nextInt();
			System.out.println("What are the x and y coordinates of the bow (front tip) of your patrol boat?");
			if (board.placeShip(new PatrolBoat(), playerScanner.nextInt(), playerScanner.nextInt(), orientation))
				break;
			System.out.println("Your ship can't fit there!");
		}
	}
}
