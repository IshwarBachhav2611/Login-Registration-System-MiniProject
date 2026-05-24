package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame implements ActionListener {

    JLabel welcomeLabel;

    JButton logoutButton;

    public WelcomeFrame(String username) {

        setTitle("Welcome");

        setSize(400, 250);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(null);

        getContentPane().setBackground(new Color(25, 25, 25));

        // Welcome Label
        welcomeLabel = new JLabel("Welcome, " + username);

        welcomeLabel.setBounds(90, 60, 250, 40);

        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));

        welcomeLabel.setForeground(Color.WHITE);

        add(welcomeLabel);

        // Logout Button
        logoutButton = new JButton("Logout");

        logoutButton.setBounds(130, 130, 120, 35);

        logoutButton.setBackground(new Color(220, 20, 60));

        logoutButton.setForeground(Color.WHITE);

        logoutButton.setFocusPainted(false);

        logoutButton.addActionListener(this);

        add(logoutButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new LoginFrame();

        dispose();
    }
}