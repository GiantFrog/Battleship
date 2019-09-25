import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Queue;

public class Listener extends Thread{
	private BufferedReader input;
	private Player localPlayer;

	public Listener(Socket inSocket, Player inLocalPlayer) {
		this.localPlayer = inLocalPlayer;
		try {
			input = new BufferedReader(new InputStreamReader(inSocket.getInputStream(),"utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String message = "";
		int[] coordinates = new int[2];
		while (true) {
			try {
				while(input.ready()) {
					message = input.readLine();
					if(localPlayer.isTurn == false && message != "") {
						System.out.println("Received: " + message);
						coordinates = parseInboundCommand(message);
						hitCoordinates(coordinates);
						message = "";
					}
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
	
	private int[] parseInboundCommand(String inString) {
		int[] coordinates = new int[2];
		
		String[] stringArray = inString.split("\\.",2);

		coordinates[0] = Integer.parseInt(stringArray[0]);
		coordinates[1] = Integer.parseInt(stringArray[1]);
		
		
		return coordinates;
	}
	private void hitCoordinates(int[] coordinates) {
		boolean hitorNah = localPlayer.board.takeShot(coordinates[0], coordinates[1]);
		if(hitorNah) {
			System.out.println("HIT");
		}else {
			System.out.println("Nah.");
		}
	}
}
