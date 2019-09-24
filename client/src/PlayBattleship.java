import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class PlayBattleship
{
	public static void main (String[] args) throws IOException
	{
		//Player player1 = new TerminalPlayer();
		Queue<String> messages = new LinkedList<>();
		
		ClientNetworkConnection client = new ClientNetworkConnection(5000, "127.0.0.1", messages);
		//client.run();
		client.sendData("This is a nice hotel.");
		
		//client.sendData("Hello Server!");
		//client.sendData("How are you?");
		
		Player player2 = new NetworkPlayer();
	}
}
