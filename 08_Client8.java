import java.io.*;
import java.net.*;

public class Client8 {
public static void main(String[] args) {
try {
// Create client socket
Socket socket = new Socket("localhost", 12345);

// Create input and output streams
PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

// Send message to server
String message = "Hello";
out.println(message);
System.out.println("Sent message to server: " + message);

// Receive response from server

String response = in.readLine();
System.out.println("Received response from server: " + response);

// Close streams and socket
out.close();
in.close();
socket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}