import java.net.*;
import java.util.Arrays;

public class UDPServer7 {
    public static void main(String[] args) {
        try {
            // Create a DatagramSocket to listen on port 9876
            DatagramSocket serverSocket = new DatagramSocket(9876);

            // Create buffers to receive and send data
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true) {
                // Receive a packet from the client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Extract the received data (a string of numbers) from the packet
                String numbersString = new String(receivePacket.getData()).trim();

                // Split the string into individual numbers
                String[] numbersArray = numbersString.split(",");

                // Convert the string numbers into an integer array
                int[] numbers = new int[numbersArray.length];
                for (int i = 0; i < numbersArray.length; i++) {
                    numbers[i] = Integer.parseInt(numbersArray[i]);

                }

                // Sort the numbers in ascending order
                Arrays.sort(numbers);

                // Convert the sorted numbers back into a string
                String sortedNumbersString = Arrays.toString(numbers);

                // Get the client's address and port from the received packet
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Create a new packet containing the sorted numbers to send back to the client
                sendData = sortedNumbersString.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress,
                        clientPort);

                // Send the packet back to the client
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}