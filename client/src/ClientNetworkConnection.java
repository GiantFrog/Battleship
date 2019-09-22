import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientNetworkConnection {
	private String url = "127.0.0.1";
	private int port = 5000;

	private BufferedReader input = null;// Input Stream from server.
	private PrintWriter output = null;// Output Stream to server.
	private Socket socket = null;

	public ClientNetworkConnection() throws IOException { // Creates a network connection for the client.
		socket = new Socket(url, port);
		socket.setKeepAlive(true); // Keeps our socket connection alive.
		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		output = new PrintWriter(socket.getOutputStream());

	}

	public String getString() { //Simple get message from server.
		String inputString = ""; // String memory for data from server. Read line by line
		String returnMessage = ""; //Full message from the server.
		try {
			while (!inputString.equals("stop")) {
				inputString = input.readLine();
				returnMessage = returnMessage.concat("\n" + inputString);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return returnMessage;
	}

	public void sendString() {//Simple send message to server.
		
	}

	public void closeConnection() {//Closes all connections and sockets. 
		try {
			socket.close();
			input.close();
			output.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
