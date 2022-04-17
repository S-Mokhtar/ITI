package team4.tictactoe.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Connection {
    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final PrintStream printStream;
    public Connection() throws IOException {
        socket = new Socket(InetAddress.getLocalHost(), 5005);
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printStream = new PrintStream(socket.getOutputStream());
    }

    public Socket getSocket() {
        return socket;
    }

    public BufferedReader getDataInputStream() {
        return bufferedReader;
    }

    public PrintStream getPrintStream() {
        return printStream;
    }
}
