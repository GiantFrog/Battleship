
public class BattleshipServer {
	public static void main(String[] args) {

		Server server = new Server(5000);
		server.run();
		server.sendData("This stuff");
		server.sendData("This other stuff.");
	}
}
