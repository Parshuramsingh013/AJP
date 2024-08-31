import java.net.InetAddress;
import java.util.Scanner;

public class ResolveHostName3 {
public static void main(String[] args) {
try {
// Get input host name from the user
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the host name: ");
String hostName = scanner.nextLine();
scanner.close();
// Resolve host name to InetAddress
InetAddress inetAddress = InetAddress.getByName(hostName);
// Print the host name and corresponding IP address
System.out.println("Host Name: " + inetAddress.getHostName());
System.out.println("IP Address: " + inetAddress.getHostAddress());
} catch (Exception e) {
e.printStackTrace();
}
}
}