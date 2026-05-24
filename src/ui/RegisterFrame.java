package ui;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame implements ActionListener {

    JLabel titleLabel, nameLabel, usernameLabel,
            emailLabel, passwordLabel, confirmPasswordLabel;

    JTextField nameField, usernameField, emailField;

    JPasswordField passwordField, confirmPasswordField;

    JButton registerButton, backButton;

    // DAO Object
    UserDAO userDAO = new UserDAO();

    public RegisterFrame() {

        setTitle("Register");

        setSize(450, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        getContentPane().setBackground(new Color(40, 40, 40));

        // ===== Title =====
        titleLabel = new JLabel("REGISTER");

        titleLabel.setBounds(130, 30, 200, 40);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));

        titleLabel.setForeground(Color.WHITE);

        add(titleLabel);

        // ===== Full Name =====
        nameLabel = new JLabel("Full Name");

        nameLabel.setBounds(50, 100, 120, 25);

        nameLabel.setForeground(Color.WHITE);

        add(nameLabel);

        nameField = new JTextField();

        nameField.setBounds(180, 100, 180, 30);

        add(nameField);

        // ===== Username =====
        usernameLabel = new JLabel("Username");

        usernameLabel.setBounds(50, 150, 120, 25);

        usernameLabel.setForeground(Color.WHITE);

        add(usernameLabel);

        usernameField = new JTextField();

        usernameField.setBounds(180, 150, 180, 30);

        add(usernameField);

        // ===== Email =====
        emailLabel = new JLabel("Email");

        emailLabel.setBounds(50, 200, 120, 25);

        emailLabel.setForeground(Color.WHITE);

        add(emailLabel);

        emailField = new JTextField();

        emailField.setBounds(180, 200, 180, 30);

        add(emailField);

        // ===== Password =====
        passwordLabel = new JLabel("Password");

        passwordLabel.setBounds(50, 250, 120, 25);

        passwordLabel.setForeground(Color.WHITE);

        add(passwordLabel);

        passwordField = new JPasswordField();

        passwordField.setBounds(180, 250, 180, 30);

        add(passwordField);

        // ===== Confirm Password =====
        confirmPasswordLabel = new JLabel("Confirm Password");

        confirmPasswordLabel.setBounds(50, 300, 120, 25);

        confirmPasswordLabel.setForeground(Color.WHITE);

        add(confirmPasswordLabel);

        confirmPasswordField = new JPasswordField();

        confirmPasswordField.setBounds(180, 300, 180, 30);

        add(confirmPasswordField);

        // ===== Register Button =====
        registerButton = new JButton("Register");

        registerButton.setBounds(90, 380, 120, 35);

        registerButton.setBackground(new Color(60, 179, 113));

        registerButton.setForeground(Color.WHITE);

        registerButton.setFocusPainted(false);

        registerButton.addActionListener(this);

        add(registerButton);

        // ===== Back Button =====
        backButton = new JButton("Back");

        backButton.setBounds(230, 380, 120, 35);

        backButton.addActionListener(this);

        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // ===== REGISTER BUTTON =====
        if (e.getSource() == registerButton) {

            String fullName =
                    nameField.getText().trim();

            String username =
                    usernameField.getText().trim();

            String email =
                    emailField.getText().trim();

            String password =
                    String.valueOf(passwordField.getPassword()).trim();

            String confirmPassword =
                    String.valueOf(confirmPasswordField.getPassword()).trim();

            // Empty Validation
            if (fullName.isEmpty() ||
                    username.isEmpty() ||
                    email.isEmpty() ||
                    password.isEmpty() ||
                    confirmPassword.isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Please fill all fields");

                return;
            }

            // Password Validation
            if (!password.equals(confirmPassword)) {

                JOptionPane.showMessageDialog(this,
                        "Passwords do not match");

                return;
            }

            // Username Exists Check
            if (userDAO.isUsernameExists(username)) {

                JOptionPane.showMessageDialog(this,
                        "Username already exists");

                return;
            }

            // Create User Object
            User user = new User(
                    fullName,
                    username,
                    email,
                    password
            );

            // Save User in DB
            boolean success =
                    userDAO.registerUser(user);

            if (success) {

                JOptionPane.showMessageDialog(this,
                        "Registration Successful");

                new LoginFrame();

                dispose();

            } else {

                JOptionPane.showMessageDialog(this,
                        "Registration Failed");
            }
        }

        // ===== BACK BUTTON =====
        if (e.getSource() == backButton) {

            new LoginFrame();

            dispose();
        }
    }
}