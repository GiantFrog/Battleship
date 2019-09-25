import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class PlayBattleship
{
	public static void main (String[] args) throws IOException
	{
		Player player1 = new TestPlayer();		
		ClientNetworkConnection client = new ClientNetworkConnection(5000, "127.0.0.1", player1);
		//client.run();
		client.sendData("0.0");
		//client.sendData("Hello Server!");
		//client.sendData("How are you?");
		
		Player player2 = new NetworkPlayer();
	}
}
