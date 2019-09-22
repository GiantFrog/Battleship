import java.io.IOException;

public class PlayBattleship
{
	public static void main (String[] args) throws IOException
	{
		Player player1 = new LocalPlayer();
		Player player2 = new NetworkPlayer();
		
		ClientNetworkConnection client = new ClientNetworkConnection();
		System.out.println(client.getString());
		client.closeConnection();
	}
}
