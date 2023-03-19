import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FirstClient {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(ServerSettings.HOST, ServerSettings.PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Denis");

            System.out.println(in.readLine());
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
