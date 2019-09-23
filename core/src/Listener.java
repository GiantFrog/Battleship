import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Listener extends Thread{
	private Socket socket;
	private BufferedReader input;

	public Listener(Socket inSocket, int inPort) {
		this.socket = inSocket;
		try {
			input = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				while(input.ready()) {
					System.out.println(input.readLine());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
