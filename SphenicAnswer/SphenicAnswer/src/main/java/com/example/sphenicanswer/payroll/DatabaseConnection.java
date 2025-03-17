package com.example.sphenicanswer.payroll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
        String user = "root";  // Change if needed
        String password = "";  // Enter your MySQL password if you set one

        // SQL query with placeholders (?)
        String sql = "INSERT INTO users (name, hours_worked, wage_per_hour) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set values for placeholders
            pstmt.setString(1, "Alice");
            pstmt.setDouble(2, 40.5);
            pstmt.setDouble(3, 150.75);

            // Execute the query
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Data inserted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }
}

