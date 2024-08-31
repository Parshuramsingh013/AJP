import java.io.*;
import java.net.*;

public class server9 {
public static void main(String[] args) {
final int PORT = 12345;

try {
ServerSocket serverSocket = new ServerSocket(PORT);
System.out.println("Server started. Waiting for client...");

while (true) {
Socket clientSocket = serverSocket.accept();
System.out.println("Client connected.");

BufferedReader reader = new BufferedReader(new
InputStreamReader(clientSocket.getInputStream()));
PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

// Read two numbers from the client
int num1 = Integer.parseInt(reader.readLine());
int num2 = Integer.parseInt(reader.readLine());

// Calculate sum
int sum = num1 + num2;

// Send the sum back to the client

writer.println("The sum of " + num1 + " and " + num2 + " is: " + sum);

// Close the connection
clientSocket.close();
System.out.println("Connection closed.");
}
} catch (IOException e) {
e.printStackTrace();
}
}
}