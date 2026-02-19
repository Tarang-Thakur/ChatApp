import java.net.*;

import java.io.*;
import java.net.Socket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Client extends JFrame {
    Socket socket;
    BufferedReader br;
    PrintWriter pw;

    private JLabel heading=new JLabel("Client Area");
    private JTextArea message=new JTextArea();
    private JTextField Input=new JTextField();
    private Font font=new Font("Roboto",Font.PLAIN,20);
    
    public Client() {
        try {
            System.out.println("Connecting to server...");
            socket = new Socket("127.0.0.1", 7777);
            System.out.println("Connected to server.");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            createGUI();
            handleEvent();

            startReading();
            // startWriting();

        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    private void handleEvent() {
        Input.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                // throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                // throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");

                // System.out.println("Key released: " + e.getKeyCode());
                if(e.getKeyCode() == 10){
                    // System.out.println("Enter key released");
                    String contentToSend = Input.getText();
                    message.append("Me : "+contentToSend+"\n");
                    message.setCaretPosition(message.getDocument().getLength());
                    pw.println(contentToSend);
                    pw.flush();
                    Input.setText("");
                    Input.requestFocus();
                }
            }
        
        });
    }

    private void createGUI(){
        // Set up the GUI components
        this.setTitle("Client Messenger");
        this.setSize(500, 700); 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        heading.setFont(font);
        message.setFont(font);
        Input.setFont(font);

        ImageIcon rawIcon = new ImageIcon("logo2.png");
        Image scaledImg = rawIcon.getImage().getScaledInstance(54, 54, Image.SCALE_SMOOTH);
        heading.setIcon(new ImageIcon(scaledImg));

        heading.setHorizontalTextPosition(SwingConstants.CENTER);
        heading.setVerticalTextPosition(SwingConstants.BOTTOM);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Add padding to the
        message.setEditable(false);
        Input.setHorizontalAlignment(SwingConstants.CENTER);

        this.setLayout(new BorderLayout()); //frame ka layout set karenge
        
        this.add(heading, BorderLayout.NORTH);
        JScrollPane jScrollPane = new JScrollPane(message);
        this.add(jScrollPane, BorderLayout.CENTER);
        this.add(Input, BorderLayout.SOUTH);


        this.setVisible(true);
    }
    
    public void startReading() {
        Runnable r1 = () -> {
            System.out.println("Reader started...");
            while (true) {

                try {
                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("Client terminated the chat.");
                        JOptionPane.showMessageDialog(this, "Server terminated the chat.", "Chat Ended", JOptionPane.INFORMATION_MESSAGE);
                        Input.setEnabled(false);
                        socket.close();
                        break;
                    }
                    // System.out.println("Client: " + msg);
                    message.append("Server: " + msg + "\n");
                    message.setCaretPosition(message.getDocument().getLength());
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
        System.out.println("Client is starting...");
        new Client();
    }

}
