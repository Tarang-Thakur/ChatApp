import java.io.*;
import java.net.*;

class Server {
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter pw;

    Server() {
        try {
            server = new ServerSocket(7777);
            System.out.println("Server initialized.");
            System.out.println("Waiting for client connection...");
            socket = server.accept();
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());
            
            startReading();
            startWriting();
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
        

    public void startReading() {
        Runnable r1 = () -> {
            System.out.println("Reader started...");
            while (true) {

                try {
                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("Client terminated the chat.");
                        socket.close();
                        break;
                    }
                    System.out.println("Client: " + msg);
                } catch (Exception e) {
                    System.out.println("Connection closed.");
                    break;
                }
            }
        };
        new Thread(r1).start();
        
    }

    public void startWriting() {
        Runnable r2 = () -> {
            System.out.println("Writer started...");
                while(true) {
                    try {
                        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                        String content = br1.readLine();
                        pw.println(content);
                        pw.flush();
                    } catch (Exception e) {
                        System.out.println("Connection closed.");
                        break;
                    }
                }
        };
        new Thread(r2).start();
    }


    public static void main(String[] args) {
        System.out.println("Server is running...");
        new Server();
    }
}