import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(23444);
        while (true) {
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    if (line.equals("end")) {
                        break;
                    } else {
                        int value = Integer.parseInt(line);
                        int clientNumberFibonacci = 0;
                        if (value == 0 || value == 1) {
                            clientNumberFibonacci = value;
                        } else {
                            int firstNumber = 0;
                            int secondNumber = 1;
                            for (int i = 2; i <= value; i++) {
                                clientNumberFibonacci = firstNumber + secondNumber;
                                firstNumber = secondNumber;
                                secondNumber = clientNumberFibonacci;

                            }
                        }

                        out.println("Число фибоначи с n по " + value + ", равно " + clientNumberFibonacci);
                    }
                }

            }
        }
    }
}


