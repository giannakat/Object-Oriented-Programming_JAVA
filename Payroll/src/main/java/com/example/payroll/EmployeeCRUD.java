package com.example.payroll;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeCRUD {

    // ✅ INSERT Employee
    public static void insertEmployee(Employee employee) {
        String sql = "INSERT INTO users (name, hours_worked, wage_per_hour) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, employee.name);
            pstmt.setDouble(2, employee.hours);
            pstmt.setDouble(3, employee.wage);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if(rs.next()){
                employee.id = rs.getInt(1);
            }
            System.out.println("Employee added to database!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ✅ UPDATE Employee
    public static void updateEmployee(Employee employee) {
        String sql = "UPDATE users SET hours_worked = ?, wage_per_hour = ?, name = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, employee.hours);
            pstmt.setDouble(2, employee.wage);
            pstmt.setString(3, employee.name);
            pstmt.setInt(4, employee.id);
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

    // ✅ DELETE Employee
    public static void deleteEmployee(int employeeId) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Employee deleted successfully!");
            } else {
                System.out.println("⚠️ No employee found with the given ID!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    // ✅ LOAD Employees from Database
    public static ObservableList<Employee> loadEmployees() {
        ObservableList<Employee> employeeList = FXCollections.observableArrayList();
        String sql = "SELECT id, name, hours_worked, wage_per_hour FROM users";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                employeeList.add(new Employee(
                        rs.getInt("id"),
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
