import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 8189;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args) {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            socket = server.accept();
            System.out.println("Client connect");
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            Thread messageToClient = new Thread(() -> {
                while (true) {
                    try {
                        System.out.println("Введите сообщение или /end для закрытия сервера");
                        String str = reader.readLine();
                        System.out.println("Вы: " + str);
                        out.println(str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            messageToClient.setDaemon(true);
            messageToClient.start();

            while (true) {
                    String clientMessage = in.readLine();
                    if (clientMessage.equals("/end")) {
                        System.out.println("Клиент вышел из чата");
                        break;
                    }
                    System.out.println("Client: " + clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
