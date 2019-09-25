import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;

public class Server extends Thread {
	private int port;
	private ServerSocket server = null;
	private Socket socket = null;

	public Server(int inPort, Player localPlayer) {
		port = inPort;
		try {
			server = new ServerSocket(port);
			System.out.println("Waiting for connection...");
			socket = server.accept();
			socket.setKeepAlive(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread inputThread = new Listener(socket, localPlayer, port);
		inputThread.start();
	}

	public void sendData(String inString) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread outputThread = new Sender(socket, port, inString);
		outputThread.start();
	}
}
