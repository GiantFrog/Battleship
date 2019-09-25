import java.io.IOException;
import java.net.Socket;

public class ClientNetworkConnection extends Thread {
	private int port;
	private Socket socket = null;

	public ClientNetworkConnection(int inPort, String url,Player localPlayer){ // Creates a network connection for the client.
		port = inPort;
		try {
			socket = new Socket(url, port);
			Thread inputThread = new Listener(socket, localPlayer,port);
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
