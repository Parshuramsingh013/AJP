// UDPServer.java
import java.net.*;
public class UDPServer6 {
public static void main(String[] args) throws Exception {
// Create a DatagramSocket that listens on port 8585
DatagramSocket ds = new DatagramSocket(8585);
// Create a buffer to store the incoming data
byte[] buf = new byte[1024];
// Create a DatagramPacket to receive the data
DatagramPacket dp = new DatagramPacket(buf, 1024);
// Receive the data
ds.receive(dp);
// Convert the received data to a string
String str = new String(dp.getData(), 0, dp.getLength());
System.out.println("Received from client: " + str);
// Reverse the string using StringBuilder&#39;s reverse() method
String reversedStr = new StringBuilder(str).reverse().toString();
System.out.println("Sent reversed message to client: " + reversedStr);
// Get the client&#39;s IP address and port from the received packet
InetAddress ip = dp.getAddress();
int port = dp.getPort();
// Create a DatagramPacket to send the reversed string
DatagramPacket dpSend = new DatagramPacket(reversedStr.getBytes(),
reversedStr.length(), ip, port);
// Send the reversed string
ds.send(dpSend);
// Close the DatagramSocket
ds.close();
}
}
