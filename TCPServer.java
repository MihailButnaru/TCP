
import java.io.*;
import java.net.*;
/*
* TCP Server author MIHAIL BUTNARU
*/
class TCPServer {
	public static void main(String argv[]) throws Exception {
		String clientSentence;		// Stores sentence sent by client.
		String upperCaseSentence;	// Uppercase sentence.
        System.out.println();
        System.out.println("========================= MIHAIL'S BUTNARU SERVER =======================");
		
		// Creates a server socket, which waits for clients 
		// to initiate connection.
		ServerSocket welcomeConnection = new ServerSocket(20001);
		
		while (true) {
			System.out.println("Waiting for clients to connect....");
			
			// Creates a new socket when a client contacts 
			// the server for the first time.
			Socket connection = welcomeConnection.accept();
			
			System.out.println("Client Connected.");
			
			BufferedReader fromClient = new BufferedReader(
					new InputStreamReader(connection.getInputStream()));
			
			DataOutputStream toClient = new DataOutputStream(
					connection.getOutputStream());
			
	
			clientSentence = fromClient.readLine();
			System.out.println("Client sent: " + clientSentence);
			upperCaseSentence = clientSentence.toUpperCase() + '\n';
            
			
			toClient.writeBytes(upperCaseSentence);
		}
	}
}