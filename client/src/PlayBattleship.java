import java.io.IOException;

public class PlayBattleship
{
	public static void main (String[] args) throws IOException
	{
		Player player1 = new TerminalPlayer();
		Player player2 = new NetworkPlayer();
		
		ClientNetworkConnection client = new ClientNetworkConnection(5000);
		client.run();
		
		client.sendData("Hello Server!");
		client.sendData("How are you?");
	}
}
