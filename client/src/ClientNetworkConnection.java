import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Queue;

public class ClientNetworkConnection extends Thread {
	private int port;
	//private BufferedReader input = null;// Input Stream from server.
	//private PrintWriter output = null;// Output Stream to server.
	private Socket socket = null;

	public ClientNetworkConnection(int inPort, String url,Player localPlayer){ // Creates a network connection for the client.
		port = inPort;
		try {
			socket = new Socket(url, port);
			//DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			//output = new PrintWriter(socket.getOutputStream());
			//output.println("Hello There.");
			//output.flush();
			
			Thread inputThread = new Listener(socket, localPlayer);
			inputThread.start();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
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
