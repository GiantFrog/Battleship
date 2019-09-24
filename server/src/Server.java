import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Queue;

public class Server extends Thread {
	private int port;
	protected BufferedReader input = null;
	protected PrintWriter output = null;
	private ServerSocket server = null;
	private Socket socket = null;
	public String data = "";

	public Server(int inPort, Queue<String> messages) {
		port = inPort;
		try {
			server = new ServerSocket(port);
			socket = server.accept();
			socket.setKeepAlive(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread inputThread = new Listener(socket, messages);
		inputThread.start();
	}

	public void sendData(String inString) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread outputThread = new Sender(socket, port, inString);
		outputThread.start();
	}

}
