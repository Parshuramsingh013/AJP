import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class Client5 {
public static void main(String[] args) throws Exception {
// Create a scanner to read the user input

Scanner scanner = new Scanner(System.in);
// Create a socket to communicate with the server
DatagramSocket socket = new DatagramSocket();
// Get the server's address
InetAddress serverAddress = InetAddress.getByName("localhost");
// Get the file name from the user
System.out.print("Enter the file name: ");
String fileName = scanner.nextLine();
// Convert the file name to bytes
byte[] fileNameBytes = fileName.getBytes();
// Create a packet to send the file name to the server
DatagramPacket request = new DatagramPacket(fileNameBytes, fileNameBytes.length,
serverAddress, 4445);
socket.send(request);
System.out.println("Sent request to server");
// Create a buffer to store the incoming data
byte[] buffer = new byte[1024];
// Create a packet to receive the server's response
DatagramPacket response = new DatagramPacket(buffer, buffer.length);
socket.receive(response);
System.out.println("Received response from server");
// Get the response data as a string
String responseData = new String(response.getData(), 0, response.getLength());
// Check if the response is an error message or the file content
if (responseData.startsWith("File not found or not readable")) {
// Print the error message
System.out.println(responseData);
} else {
// Print the file content
System.out.println("File content:\n" + responseData);
}
// Close the socket and the scanner
socket.close();
scanner.close();
}
}