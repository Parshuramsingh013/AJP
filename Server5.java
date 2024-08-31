import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class Server5 {
public static void main(String[] args) throws Exception {
// Create a socket to listen on port 4445
DatagramSocket socket = new DatagramSocket(4445);
System.out.println("Server is listening on port 4445");
// Create a buffer to store the incoming data
byte[] buffer = new byte[1024];
// Create a packet to receive the client's request
DatagramPacket request = new DatagramPacket(buffer, buffer.length);
socket.receive(request);
System.out.println("Received request from client");
// Get the client's address and port
InetAddress clientAddress = request.getAddress();
int clientPort = request.getPort();
// Get the file name from the request
String fileName = new String(request.getData(), 0, request.getLength());
System.out.println("Requested file: " + fileName);
// Create a path object for the file
Path filePath = Paths.get(fileName);
// Check if the file exists and is readable
if (Files.exists(filePath) && Files.isReadable(filePath)) {
// Read the file content as bytes
byte[] fileContent = Files.readAllBytes(filePath);
// Create a packet to send the file content to the client
DatagramPacket response = new DatagramPacket(fileContent, fileContent.length,
clientAddress, clientPort);
socket.send(response);
System.out.println("Sent file content to client");

} else {
// Create a message to indicate that the file is not found or not readable
String message = "File not found or not readable";
byte[] messageContent = message.getBytes();
// Create a packet to send the message to the client
DatagramPacket response = new DatagramPacket(messageContent,
messageContent.length, clientAddress, clientPort);
socket.send(response);
System.out.println("Sent error message to client");
}
// Close the socket
socket.close();
}
}