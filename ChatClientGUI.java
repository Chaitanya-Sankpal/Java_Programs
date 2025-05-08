import javax.swing.*;
import java.net.*;
import java.io.*;

public class ChatClientGUI{
    public static void main(String[] args) throws Exception {
        JFrame f = new JFrame("Client");
        JTextArea area = new JTextArea();
        JTextField field = new JTextField();
        f.setSize(300, 400);
        f.setLayout(new java.awt.BorderLayout());
        f.add(new JScrollPane(area), "Center");
        f.add(field, "South");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        Socket socket = new Socket("localhost", 2000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        area.append("Connected to Server\n");

        field.addActionListener(e -> {
            String msg = field.getText();
            area.append("Me: " + msg + "\n");
            out.println(msg);
            field.setText("");
            if (msg.equalsIgnoreCase("bye")) System.exit(0);
        });

        String msg;
        while ((msg = in.readLine()) != null) {
            area.append("Server: " + msg + "\n");
            if (msg.equalsIgnoreCase("bye")) System.exit(0);
        }
    }
}
