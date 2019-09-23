import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	protected int port;
	protected BufferedReader input = null;
	protected PrintWriter output = null;
	protected ServerSocket server = null;
	protected Socket socket = null;
	public String data = "";

	public Server(int inPort) {
		port = inPort;
		try {
			server = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void run() {

		try {
			socket = server.accept();
			socket.setKeepAlive(true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Thread inputThread = new Listener(socket, port);
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
