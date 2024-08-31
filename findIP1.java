import java.net.InetAddress;
import java.net.UnknownHostException;

public class findIP1 {
    public static void main(String[] args) {
        try {
            // Get the local host address
            InetAddress localhost = InetAddress.getLocalHost();
            // Print the IP address
            System.out.println("Local IP Address: " + localhost.getHostAddress());
        } catch (UnknownHostException e) {
            System.err.println("Unable to determine local host IP address");
            e.printStackTrace();
        }
    }
}
