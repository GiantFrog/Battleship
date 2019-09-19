public class LocalPlayer extends Player
{
	public LocalPlayer()
	{
		super("Avery the Local");
	}
	public LocalPlayer (String name)
	{
		super(name);
	}
	
	//generates and returns a board from user input
	private Board setupBoard()
	{
		//TODO ask the user where to place the ships and make a board out of it!
		return new Board(this);
	}
}
