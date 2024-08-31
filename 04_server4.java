import java.io.*;
import java.net.*;
import java.util.*;

public class server4 {
    // Defines the port number for the server to listen on
    private static final int PORT = 7777;

    public static void main(String args[]) throws IOException {
        // Create a server socket and listen for connections on the specified port
        ServerSocket ss = new ServerSocket(PORT);
        System.out.println("Server started, listening on port " + PORT);
        // Accept a connection from a client
        Socket s = ss.accept();
        System.out.println("Client connected");
        // Get input and output streams for communication with the client
        InputStream is = s.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        PrintStream ps = new PrintStream(s.getOutputStream());
        // Read the line of numbers sent by the client
        String numbersString = br.readLine();
        System.out.println("Received numbers from client: " + numbersString);
        // Split the string into an array of individual numbers
        String[] numbersStrings = numbersString.split(" ");
        // Initialize the sum to 0
        int sum = 0;

        // Iterate through the numbers array
        for (String numberStr : numbersStrings) {
            try {
                // Attempt to convert the string to an integer
                int number = Integer.parseInt(numberStr);
                // Add the number to the sum
                sum += number;
            } catch (NumberFormatException e) {
                // Handle invalid number format by sending an error message
                ps.println("Invalid number format: " + numberStr);
                // Stop processing numbers if one is invalid
                break;
            }
        }
        // Check if any valid numbers were received
        if (numbersStrings.length > 0)

        {
            // Send the calculated sum to the client
            System.out.println("Sum of numbers: " + sum);
        } else {
            // Send a message indicating no valid numbers were received
            System.out.println("No valid numbers received.");
        }
        // Close all streams and sockets
        ps.close();
        ss.close();
        s.close();
    }
}