import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Queue;

public class Listener extends Thread{
	private BufferedReader input;
	private Queue<String> messages;

	public Listener(Socket inSocket, Queue<String> messages) {
		this.messages = messages;
		try {
			input = new BufferedReader(new InputStreamReader(inSocket.getInputStream(),"utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				//TODO we should execute commands here, so we don't have to check for new ones arriving in a while loop. or something.
				while(input.ready())
					messages.add(input.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
