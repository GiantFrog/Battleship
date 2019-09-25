public abstract class Player
{
	private String name;
	Board board;
	public boolean isTurn;
	public Player (String name)
	{
		this.name = name;
		this.isTurn = false;
		board = new Board(this);

	}
	
	abstract void setupBoard();
}
