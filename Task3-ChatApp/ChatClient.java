
import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        System.out.println("📶 Connected to chat server!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // Thread to read messages from server
        new Thread(() -> {
            String serverMsg;
            try {
                while ((serverMsg = input.readLine()) != null) {
                    System.out.println("👥 " + serverMsg);
                }
            } catch (IOException e) {
                System.out.println("❌ Disconnected from server.");
            }
        }).start();

        // Main thread sends user input to server
        String userMsg;
        while ((userMsg = console.readLine()) != null) {
            output.println(userMsg);
        }
    }
}
