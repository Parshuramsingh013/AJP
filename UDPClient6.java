// UDPClient.java
import java.net.*;
import java.util.*;

public class UDPClient6 {
public static void main(String[] args) throws Exception {
// Create a DatagramSocket
DatagramSocket ds = new DatagramSocket();
// Get the string to send to the server from the user
Scanner scanner = new Scanner(System.in);
System.out.println("Enter a string to send to the server:");
String str = scanner.nextLine();
// Get the IP address of the server
InetAddress ip = InetAddress.getByName("localhost");
// Create a DatagramPacket to send the string
DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 8585);
// Send the string
ds.send(dp);
// Create a buffer to store the incoming data
byte[] buf = new byte[1024];
// Create a DatagramPacket to receive the data
DatagramPacket dpReceive = new DatagramPacket(buf, 1024);
// Receive the data
ds.receive(dpReceive);
// Convert the received data to a string
String receivedStr = new String(dpReceive.getData(), 0, dpReceive.getLength());
// Print the received string
System.out.println("Received: " + receivedStr);
// Close the DatagramSocket
ds.close();
}
}