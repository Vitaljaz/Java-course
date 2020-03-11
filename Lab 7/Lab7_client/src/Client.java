import java.io.*;
import java.net.Socket;

public class Client {
    private static String url;
    private static String address;
    private static int port;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static Socket socket;

    public static void main(String args[]) {
        if (args.length < 3 ) {
            System.out.println("[CLIENT]: No arguments.");
            System.exit(-1);
        }

        url = args[0];
        address = args[1];
        port = Integer.parseInt(args[2]);

        System.out.println("[CLIENT-config]: url: " + url + " ip: " + address + ":" + port);

        try {
            socket = new Socket(address, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write(url + "\n");
            out.flush();

            String data;
            while (!socket.isOutputShutdown()) {
                data = in.readLine();

                if (data == null) {
                    closeConnection();
                    break;
                }

                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[CLIENT]: Error on server side.");
            System.exit(-1);
        }
    }

    private static void closeConnection() {
        try {
            in.close();
            out.close();
            socket.close();
            System.out.println("[CLIENT]: Server finished his work.");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
