import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientNetworkConnection extends Thread {
	private String url = "127.0.0.1";
	private int port = 5000;

	private BufferedReader input = null;// Input Stream from server.
	private PrintWriter output = null;// Output Stream to server.
	private Socket socket = null;

	public ClientNetworkConnection(int inPort){ // Creates a network connection for the client.
		port = inPort;
		try {
			socket = new Socket(url, port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void run() {
		try {

			
			//DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			output = new PrintWriter(socket.getOutputStream());
			output.println("Hello There.");
			output.flush();
			
			Thread inputThread = new Listener(socket,port);
			inputThread.start();
			

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
