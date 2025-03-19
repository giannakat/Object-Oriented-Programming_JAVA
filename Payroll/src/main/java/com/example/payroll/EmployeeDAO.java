package com.example.payroll;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeDAO {

    // ✅ INSERT Employee
    public static void insertEmployee(Employee employee) {
        String sql = "INSERT INTO users (name, hours_worked, wage_per_hour) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, employee.name);
            pstmt.setDouble(2, employee.hours);
            pstmt.setDouble(3, employee.wage);
            pstmt.executeUpdate();
            System.out.println("Employee added to database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ UPDATE Employee
    public static void updateEmployee(Employee employee) {
        String sql = "UPDATE users SET hours_worked = ?, wage_per_hour = ? WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, employee.hours);
            pstmt.setDouble(2, employee.wage);
            pstmt.setString(3, employee.name);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee updated successfully!");
            } else {
                System.out.println("⚠️ No rows updated. Check ID!");
            }
            System.out.println("Employee updated!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ LOAD Employees from Database
    public static ObservableList<Employee> loadEmployees() {
        ObservableList<Employee> employeeList = FXCollections.observableArrayList();
        String sql = "SELECT name, hours_worked, wage_per_hour FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                employeeList.add(new Employee(
                        rs.getString("name"),
                        rs.getDouble("hours_worked"),
                        rs.getDouble("wage_per_hour")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
