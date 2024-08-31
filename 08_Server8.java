import java.io.*;
import java.net.*;

public class Server8 {
public static void main(String[] args) {
try {
// Create server socket
ServerSocket serverSocket = new ServerSocket(12345);

// Accept client connection
Socket clientSocket = serverSocket.accept();
System.out.println("Client connected.");

// Create input and output streams
BufferedReader in = new BufferedReader(new
InputStreamReader(clientSocket.getInputStream()));
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

// Read message from client
String message = in.readLine();
System.out.println("Received message from client: " + message);

// Send response to client
out.println("Hello from server!");

// Close streams and sockets
in.close();

out.close();
clientSocket.close();
serverSocket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}