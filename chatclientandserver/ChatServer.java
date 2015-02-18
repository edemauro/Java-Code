package NetworkingExample;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer{
	// holds all of the clientOutputStreams
	ArrayList clientOutputStreams;
	
	public class ClientHandler implements Runnable{
		BufferedReader reader;
		Socket sock;
		
		public ClientHandler(Socket clientSocket){
			// read input from client
			try{
				sock = clientSocket;
				InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(isReader);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} // close ctor
		
		// required b/c runnable interface
		public void run(){
			// read message from a client and send it to everyone
			String message;
			try{
				while((message = reader.readLine()) != null){
					System.out.println("read " + message);
					tellEveryone(message);
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		} // close run
	} // close ClientHandler inner class
	
	public static void main(String[] args){
		new ChatServer().go();
	} // close main method
	
	public void go(){
		clientOutputStreams = new ArrayList();
		try{
			// creating a server
			ServerSocket serverSock = new ServerSocket(5000);
			
			while(true){
				// accept a connection from each client
				// create ouput streams to each client and add to array
				Socket clientSocket = serverSock.accept();
				
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				clientOutputStreams.add(writer);
				
				// create a new thread for each client and connect
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("got a connection.");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	} // close go method
	
	public void tellEveryone(String message){
		Iterator it = clientOutputStreams.iterator();
		
		// iterate through the array and send message to each client
		while(it.hasNext()){
			try{
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	} // close tellEveryone method
}
