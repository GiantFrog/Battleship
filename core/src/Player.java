public abstract class Player
{
	private String name;
	Board board;
	
	public Player (String name)
	{
		this.name = name;
		board = new Board(this);
		setupBoard();
	}
	
	abstract void setupBoard();
}
