import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Queue;
import java.util.Scanner;

public class Listener extends Thread{
	private BufferedReader input;
	private Player localPlayer;
	private NetworkPlayer netPlayer = new NetworkPlayer();
	private Socket socket;
	private int port,lastx,lasty;
	public Listener(Socket inSocket, Player inLocalPlayer, int inPort) {
		this.localPlayer = inLocalPlayer;
		this.port = inPort;
		this.socket = inSocket;
		try {
			input = new BufferedReader(new InputStreamReader(inSocket.getInputStream(),"utf-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String message = "";
		while (true) {
			try {
				while(input.ready()) {
					message = input.readLine();
					System.out.println("Received: " + message);
					switch(message){
						case "Your Turn.":
							fire();
							sendData("Your Turn.");
							break;
						case "HIT":
							netPlayer.board.wasHit(lastx, lasty);
							System.out.println("Their Board");
							System.out.println(netPlayer.board.getBoard());
							break;
						case "MISS":
							netPlayer.board.wasMissed(lastx, lasty);
							System.out.println("Their Board");
							System.out.println(netPlayer.board.getBoard());
							break;
						case "":
							break;
						default: //Coordinates
							hitMeCoordinates(parseInboundCommand(message));
					}
				}
			} catch (IOException e) {

				e.printStackTrace();
			}
			//very lazy way to keep this thing from maxing out the CPU
			try
			{
				Thread.sleep(1000, 0);
			}
			catch (InterruptedException e)
			{
				System.out.println("Oh no.");
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
	private void hitMeCoordinates(int[] coordinates) {
		boolean hitorNah = localPlayer.board.takeShot(coordinates[0], coordinates[1]);
		if(hitorNah) {
			System.out.println("You are HIT");
			sendData("HIT");
		}else {
			System.out.println("Nah. Didn't hit.");
			sendData("MISS");
		}
		System.out.println("Your Board");
		System.out.println("");
		System.out.println(localPlayer.board.getBoard());
	}
	
	private void sendData(String inString) { //Send data to client.
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread outputThread = new Sender(socket, port, inString);
		outputThread.start();
	}
	
	private void fire() {
		System.out.println("What is your X to fire?");
		Scanner scan = new Scanner(System.in);
		String x = scan.next();
		lastx  = Integer.parseInt(x);
		System.out.println("What is your Y to fire?");
		String y = scan.next();
		lasty = Integer.parseInt(y);
		String message = x.concat("." + y);
		System.out.println("Firing.");
		this.sendData(message);
		System.out.println("Waiting for other player to take their turn.");
		
	}
}
