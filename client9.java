import java.io.*;
import java.net.*;

public class client9 {
public static void main(String[] args) {
final String SERVER_ADDRESS = "localhost";
final int PORT = 12345;

try {
Socket socket = new Socket(SERVER_ADDRESS, PORT);

BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

// Read two numbers from the user
System.out.print("Enter first number: ");

int num1 = Integer.parseInt(reader.readLine());
System.out.print("Enter second number: ");
int num2 = Integer.parseInt(reader.readLine());

// Send the numbers to the server
writer.println(num1);
writer.println(num2);

// Read the response from the server
BufferedReader serverReader = new BufferedReader(new
InputStreamReader(socket.getInputStream()));
String response = serverReader.readLine();
System.out.println("Server response: " + response);

// Close the connection
socket.close();
} catch (IOException e) {
e.printStackTrace();
}
}
}