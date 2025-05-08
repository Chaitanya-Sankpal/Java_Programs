import javax.swing.*;
import java.net.*;
import java.io.*;

public class ChatServerGUI {
    public static void main(String[] args) throws Exception {
        JFrame f = new JFrame("Server");
        JTextArea area = new JTextArea();
        JTextField field = new JTextField();
        f.setSize(300, 400);
        f.setLayout(new java.awt.BorderLayout());
        f.add(new JScrollPane(area), "Center");
        f.add(field, "South");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        ServerSocket server = new ServerSocket(2000);
        Socket socket = server.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        area.append("Client connected\n");

        field.addActionListener(e -> {
            String msg = field.getText();
            area.append("Me: " + msg + "\n");
            out.println(msg);
            field.setText("");
            if (msg.equalsIgnoreCase("bye")) System.exit(0);
        });

        String msg;
        while ((msg = in.readLine()) != null) {
            area.append("Client: " + msg + "\n");
            if (msg.equalsIgnoreCase("bye")) System.exit(0);
        }
    }
}
