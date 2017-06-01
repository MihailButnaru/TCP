import java.io.*;
import java.net.*;
/*
* author MIHAIL BUTNARU
* TCP Client
*/
class TCPClient {
 public static void main(String argv[]) throws Exception {
  System.out.println("========================= MIHAIL'S BUTNARU CLIENT SIDE ====================");
  String sentence;
  String modifiedSentence;
  BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
  Socket clientSocket = new Socket("localhost", 20001);
  DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
  BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  System.out.print("Enter message to send: ");
  sentence = inFromUser.readLine();
  outToServer.writeBytes(sentence + '\n');
  modifiedSentence = inFromServer.readLine();
  System.out.println("FROM SERVER: " + modifiedSentence);
  clientSocket.close();
 }
}