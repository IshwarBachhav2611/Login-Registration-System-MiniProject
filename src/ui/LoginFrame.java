package ui;

import dao.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {

    JLabel titleLabel, usernameLabel,
            passwordLabel, registerLabel;

    JTextField usernameField;

    JPasswordField passwordField;

    JButton loginButton, registerButton;

    UserDAO userDAO = new UserDAO();

    public LoginFrame() {

        // Frame Title
        setTitle("Login System");

        // Frame Size
        setSize(400, 350);

        // Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Center frame
        setLocationRelativeTo(null);

        // Manual Layout
        setLayout(null);

        // Background Color
        getContentPane().setBackground(new Color(30, 30, 30));

        // ===== Title =====
        titleLabel = new JLabel("LOGIN");

        titleLabel.setBounds(140, 30, 200, 40);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));

        titleLabel.setForeground(Color.WHITE);

        add(titleLabel);

        // ===== Username Label =====
        usernameLabel = new JLabel("Username");

        usernameLabel.setBounds(50, 100, 100, 25);

        usernameLabel.setForeground(Color.WHITE);

        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        add(usernameLabel);

        // ===== Username Field =====
        usernameField = new JTextField();

        usernameField.setBounds(150, 100, 180, 30);

        usernameField.setFont(new Font("Arial", Font.PLAIN, 15));

        add(usernameField);

        // ===== Password Label =====
        passwordLabel = new JLabel("Password");

        passwordLabel.setBounds(50, 150, 100, 25);

        passwordLabel.setForeground(Color.WHITE);

        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        add(passwordLabel);

        // ===== Password Field =====
        passwordField = new JPasswordField();

        passwordField.setBounds(150, 150, 180, 30);

        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));

        add(passwordField);

        // ===== Login Button =====
        loginButton = new JButton("Login");

        loginButton.setBounds(130, 210, 120, 35);

        loginButton.setFont(new Font("Arial", Font.BOLD, 16));

        loginButton.setBackground(new Color(70, 130, 180));

        loginButton.setForeground(Color.WHITE);

        loginButton.setFocusPainted(false);

        loginButton.addActionListener(this);

        add(loginButton);

        // ===== Register Label =====
        registerLabel = new JLabel("New User?");

        registerLabel.setBounds(95, 270, 100, 20);

        registerLabel.setForeground(Color.LIGHT_GRAY);

        add(registerLabel);

        // ===== Register Button =====
        registerButton = new JButton("Register");

        registerButton.setBounds(180, 265, 100, 30);

        registerButton.setFocusPainted(false);

        registerButton.addActionListener(this);

        add(registerButton);

        // Make Frame Visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // ===== LOGIN BUTTON =====
        if (e.getSource() == loginButton) {

            String username =
                    usernameField.getText();

            String password =
                    String.valueOf(passwordField.getPassword());

            // ===== Empty Field Validation =====
            if (username.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please enter username and password");

                return;
            }

            // ===== Database Login Check =====
            boolean isValidUser =
                    userDAO.loginUser(username, password);

            if (isValidUser) {

                JOptionPane.showMessageDialog(this,
                        "Login Successful");

                new WelcomeFrame(username);

                dispose();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Invalid Username or Password");
            }
        }

        // ===== REGISTER BUTTON =====
        if (e.getSource() == registerButton) {

            new RegisterFrame();

            dispose();
        }
    }
}