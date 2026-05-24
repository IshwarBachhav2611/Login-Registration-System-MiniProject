package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Database URL
    private static final String URL =
            "jdbc:mysql://localhost:3306/login_system";

    // MySQL Username
    private static final String USER = "root";
    // MySQL Password
    private static final String PASSWORD = "ishwar2004";

    // Method to create connection
    public static Connection getConnection() {

        Connection connection = null;

        try {

            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            connection = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Database Connected Successfully!");

        } catch (Exception e) {

            System.out.println("Connection Failed!");

            e.printStackTrace();
        }

        return connection;
    }
}