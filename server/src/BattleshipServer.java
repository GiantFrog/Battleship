import java.util.LinkedList;
import java.util.Queue;

public class BattleshipServer {
	public static void main(String[] args) {
		Queue<String> messages = new LinkedList<>();
		Server server = new Server(5000, messages);
		//server.run();
		server.sendData("This stuff");
		server.sendData("This other stuff.");
	}
}
