import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class Handler extends Thread {
    private static int handlerID = 0;
    private Socket client = null;
    private BufferedReader in = null;
    private BufferedReader urlReader = null;
    private BufferedWriter out = null;
    private URLConnection connection = null;
    private Boolean connectionStatus = false;

    public Handler(Socket client) {
        handlerIdIncrease();
        this.client = client;
        System.out.println("[HANDLER " + handlerID + "]: Client connect with IP: "
                + client.getInetAddress() + " port: " + client.getPort());
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            out = new BufferedWriter(
                    new OutputStreamWriter(client.getOutputStream()));

            String site = in.readLine();
            System.out.println("[HANDLER " + handlerID + "]: URL from client: " + site);

            try {
                connection = new URL(site).openConnection();
                urlReader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                connectionStatus = true;
            } catch (UnknownHostException e) {
                System.out.println("[HANDLER " + handlerID + "]: Bad url, error with access to site.");
                connectionStatus = false;
            }

            if (connectionStatus) {
                String urlInput;
                while ((urlInput = urlReader.readLine()) != null) {
                    send(urlInput);
                }
            } else {
                send("[SERVER-ERROR]: BAD LINK!");
            }

            closeConnection();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[HANDLER " + handlerID + "]: Client disconnected.");
        }
    }

    private void handlerIdIncrease() {
        handlerID++;
    }

    private void closeConnection() {
        try {
            in.close();
            out.close();
            client.close();
            System.out.println("[HANDLER " + handlerID + "]: Client finished his work.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("[HANDLER " + handlerID + "]: Client disconnected.");
        }
    }

    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
