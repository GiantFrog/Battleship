import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PlayBattleship
{
	public static void main (String[] args) throws IOException
	{
		String ip = "127.0.0.1";
		int port = 5000;
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the ip of the server?");
		ip = scan.next();
		System.out.println("What is the port of the server?");
		port = Integer.parseInt(scan.next());
		Player player1 = new TerminalPlayer();
		System.out.println("Make sure to launch server first.");
		ClientNetworkConnection client = new ClientNetworkConnection(port, ip, player1);
		client.sendData("Your Turn.");
	}
}
