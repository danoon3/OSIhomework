import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        String city = "";
        String clientAnswer = "";
        try (ServerSocket serverSocket = new ServerSocket(ServerSettings.PORT);) {

            System.out.println("Сервер запущен");

            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream());
                ) {
                    System.out.println("Новое подключение подтверждено");
                    if (city.equals("")) {
                        out.println("???");

                        city = in.readLine();

                        out.println("OK");
                        System.out.println("Назван город " + city);
                    } else {
                        char symbol = city.charAt(city.length() - 1);
                        clientAnswer = in.readLine();
                        if (clientAnswer.toLowerCase().startsWith(String.valueOf(symbol))) {
                            city = clientAnswer;
                            out.println("OK");
                            System.out.println("Назван город " + city);
                        } else {
                            out.println("NOT OK");
                        }
                    }

                }
            }
        } catch (IOException e) {
            System.out.println("Не могу запустить сервер");
            e.printStackTrace();
        }
    }
}
