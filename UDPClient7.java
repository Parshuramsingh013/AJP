import java.net.*;
public class UDPClient7 {
public static void main(String[] args) {
try {
// Create a DatagramSocket for the client
DatagramSocket clientSocket = new DatagramSocket();

// Specify the server's address and port
InetAddress serverAddress = InetAddress.getByName("localhost");
int serverPort = 9876;

// Prepare the numbers to send to the server as a string
String numbers = "10,9,8,7,6,5,4,3,2,1";

// Convert the numbers string into bytes
byte[] sendData = numbers.getBytes();

// Create a DatagramPacket to send data to the server
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress,
serverPort);

// Send the packet to the server
clientSocket.send(sendPacket);

// Create a buffer to receive data from the server
byte[] receiveData = new byte[1024];

// Create a DatagramPacket to receive data from the server
DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

// Receive the sorted numbers from the server
clientSocket.receive(receivePacket);

// Extract the sorted numbers from the received packet
String sortedNumbers = new String(receivePacket.getData()).trim();

// Print the sorted numbers received from the server
System.out.println("Sorted numbers received from server: " + sortedNumbers);

// Close the client socket
clientSocket.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}