import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int port = 5000;
	private BufferedReader input = null;
	private PrintWriter output = null;
	private ServerSocket server = null;
	private Socket socket = null;

	public Server() {
		try {
			server = new ServerSocket(port);
			System.out.println("Created server on port " + port);
			socket = server.accept();
			socket.setKeepAlive(true);
			System.out.println("Some ass just connected");
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			output = new PrintWriter(socket.getOutputStream());
			
			listenAndSend();
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void listenAndSend() {
		String inputString = "";

		while (socket.isConnected()) {
			output.println("HTTP/1.1 200 OK");
			output.println("Hello There");
			output.println("stop");

		}
		while(socket.isConnected()) {

		}


	}

}
