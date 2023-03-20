import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();

        client.connectToServer("Тамбов");
    }

    public void connectToServer(String city) {
        try (Socket clientSocket = new Socket(ServerSettings.HOST, ServerSettings.PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println(city);
            System.out.println(in.readLine());

        } catch (IOException e) {
            e.getMessage();
        }
    }
}
