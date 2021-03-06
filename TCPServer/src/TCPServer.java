import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;

public class TCPServer {
	ServerSocket welcomeSocket;
	Socket connectionSocket;
	
	public TCPServer(int portNumber) throws IOException{
		welcomeSocket = new ServerSocket(portNumber);
		while (true) {
			recieveData();
		}
	}
	
	public void recieveData() throws IOException{
		connectionSocket = welcomeSocket.accept();getClass();
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(
				connectionSocket.getInputStream()));
		DataOutputStream outToClient = new DataOutputStream(
				connectionSocket.getOutputStream());
		outToClient.writeBytes("Please Send the Image " + '\n');
		while(true){
			String imageBytes = inFromClient.readLine();
			if(imageBytes == null)
				break;
			System.out.println("The data received is " + imageBytes);
		}
		System.out.println("Done receiving Image");
	}
	
	public static void main(String [] args) throws IOException{
		TCPServer server = new TCPServer(5000);
	}
}
