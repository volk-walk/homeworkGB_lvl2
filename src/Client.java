import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket socket;
    private static final int PORT = 8189;
    private static String IP_ADDRESS = "localhost";
    private static BufferedReader reader;
    private static BufferedReader in;
    private static PrintWriter out;

    public static void main(String[] args) {
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            Thread messageToServer = new Thread(() -> {
                while(true){
                    try {
                        System.out.println("Введите сообщение или /end для выхода");
                        String str = reader.readLine();
                        System.out.println("Вы: " + str);
                        out.println(str);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
            messageToServer.setDaemon(true);
            messageToServer.start();

            while (true) {
                    String serverMessage = in.readLine();
                    if (serverMessage.equals("/end")){
                        System.out.println("Соединение с сервером разорвано");
                        break;
                    }
                    System.out.println("Server: " + serverMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

}