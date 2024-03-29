import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Sender extends Thread {
	private Socket socket;
	private PrintWriter output;
	private String message = "";
	public Sender(Socket inSocket, int inPort, String inString) {
		this.socket = inSocket;
		message = inString;
		try {
			output = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		output.println(message);
		output.flush();
	}
}
