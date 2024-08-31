import java.io.*;
import java.net.*;
import java.util.*;

public class client4 {
    public static void main(String args[]) throws Exception {
        // Define the server's hostname and port number
        String hostname = "localhost";
        int port = 7777;

        // Create a socket to connect to the server
        Socket s = new Socket(hostname, port);

        // Get input and output streams for communication with the server
        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        PrintStream ps = new PrintStream(s.getOutputStream());

        // Create a scanner to read input from the user

        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter numbers
        System.out.print("Enter numbers separated by spaces: ");
        String numbersString = sc.nextLine();

        // Send the string of numbers to the server
        ps.println(numbersString);

        // Continuously read and print messages from the server
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }

        // Close all streams and sockets
        ps.close();
        s.close();
    }
}