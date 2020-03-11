import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private static final int port = 2481;
    private static ServerSocket server = null;

    public static void main(String args[]) {
        try {
            server = new ServerSocket(port);
            System.out.println("[SERVER]: Started on: " + port);
        } catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
            System.exit(-1);
        }

        while (!isAlive()) {
            try {
                new Handler(server.accept()).run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            server.close();
            System.out.print("[SERVER]: Server is closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAlive() {
        return server.isClosed();
    }

    public static int getPort() {
        return port;
    }
}
