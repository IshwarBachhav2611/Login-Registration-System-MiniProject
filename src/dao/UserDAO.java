package dao;

import db.DBConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    // =========================
    // REGISTER USER
    // =========================
    public boolean registerUser(User user) {

        boolean isRegistered = false;

        try {

            Connection connection = DBConnection.getConnection();

            // Debug Check
            System.out.println("Register Method Called");

            String query =
                    "INSERT INTO users(full_name, username, email, password) VALUES (?, ?, ?, ?)";

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setString(1, user.getFullName().trim());

            ps.setString(2, user.getUsername().trim());

            ps.setString(3, user.getEmail().trim());

            ps.setString(4, user.getPassword().trim());

            int rowsInserted = ps.executeUpdate();

            System.out.println("Rows Inserted: " + rowsInserted);

            if (rowsInserted > 0) {

                isRegistered = true;

                System.out.println("Registration Successful");
            }

            connection.close();

        } catch (Exception e) {

            System.out.println("Registration Failed");

            e.printStackTrace();
        }

        return isRegistered;
    }

    // =========================
    // LOGIN USER
    // =========================
    public boolean loginUser(String username,
                             String password) {

        boolean isValidUser = false;

        try {

            Connection connection = DBConnection.getConnection();

            String query =
                    "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setString(1, username.trim());

            ps.setString(2, password.trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                isValidUser = true;

                System.out.println("Login Successful");

            } else {

                System.out.println("Invalid Username or Password");
            }

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return isValidUser;
    }

    // =========================
    // CHECK USERNAME EXISTS
    // =========================
    public boolean isUsernameExists(String username) {

        boolean exists = false;

        try {

            Connection connection = DBConnection.getConnection();

            String query =
                    "SELECT * FROM users WHERE username=?";

            PreparedStatement ps =
                    connection.prepareStatement(query);

            ps.setString(1, username.trim());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                exists = true;
            }

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return exists;
    }
}