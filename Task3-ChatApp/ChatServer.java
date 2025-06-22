
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) throws IOException {
        System.out.println("🚀 Chat Server is running...");
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("✅ New client connected: " + clientSocket);
            new ClientHandler(clientSocket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (clientWriters) {
                    clientWriters.add(out);
                }

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("📩 Received: " + message);
                    synchronized (clientWriters) {
                        for (PrintWriter writer : clientWriters) {
                            writer.println(message);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("⚠️ Error handling client: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                    synchronized (clientWriters) {
                        clientWriters.remove(out);
                    }
                    System.out.println("❌ Client disconnected.");
                } catch (IOException e) {
                    System.out.println("⚠️ Error closing socket.");
                }
            }
        }
    }
}
