import java.util.LinkedList;
import java.util.Queue;

public class BattleshipServer {
	
	public static void main(String[] args) {
		Player localPlayer = new TerminalPlayer();
		Server server = new Server(5000, localPlayer);
		//server.run();
		


	}
}
