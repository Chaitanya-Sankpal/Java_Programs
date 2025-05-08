import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentAuthApp {
    public static void main(String[] args) {
        new RegistrationForm();
    }
}

// Registration GUI
class RegistrationForm extends JFrame {
    JTextField nameField, emailField;
    JPasswordField passwordField;
    JButton registerBtn, loginBtn;

    RegistrationForm() {
        setTitle("Student Registration");
        setSize(300, 250);
        setLayout(new GridLayout(5, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        registerBtn = new JButton("Register");
        loginBtn = new JButton("Go to Login");
        add(registerBtn);
        add(loginBtn);

        registerBtn.addActionListener(e -> registerStudent());
        loginBtn.addActionListener(e -> {
            dispose();
            new LoginForm();
        });

        setVisible(true);
    }

    void registerStudent() {
        String name = nameField.getText();
        String email = emailField.getText();
        String pass = new String(passwordField.getPassword());

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "yourpassword");
            String sql = "INSERT INTO students (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, pass);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration Successful!");
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}

// Login GUI
class LoginForm extends JFrame {
    JTextField emailField;
    JPasswordField passwordField;
    JButton loginBtn;

    LoginForm() {
        setTitle("Student Login");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);

        loginBtn = new JButton("Login");
        add(new JLabel());
        add(loginBtn);

        loginBtn.addActionListener(e -> loginStudent());

        setVisible(true);
    }

    void loginStudent() {
        String email = emailField.getText();
        String pass = new String(passwordField.getPassword());

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "yourpassword");
            String sql = "SELECT * FROM students WHERE email=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome " + rs.getString("name"));
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
}