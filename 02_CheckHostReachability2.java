import java.net.InetAddress;
import java.util.Scanner;
public class CheckHostReachability2 {
public static void main(String[] args) {
try {
// Get input host name from the user
Scanner scanner = new Scanner(System.in);
System.out.print("Enter the host name to check reachability: ");
String hostName = scanner.nextLine();
scanner.close();
// Check if the host is reachable
InetAddress inetAddress = InetAddress.getByName(hostName);
boolean isReachable = inetAddress.isReachable(5000); // Timeout set to 5 seconds
// Print the result
if (isReachable) {
System.out.println("Host " + hostName + " is reachable.");
} else {
System.out.println("Host " + hostName + " is not reachable.");
}
} catch (Exception e) {
e.printStackTrace();
}
}
}