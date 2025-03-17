package com.example.payroll;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class HelloController {


    public TextField tf_hourlywage;
    public TextField tf_hoursworked;
    public Button calculate_button;
    public TextField tf_employeename;
    public ListView<Employee> lv_list;
    public HBox hb_progcontainer;
    public Text salary_view;
    public Button btnSave;
    private Employee current;

    public void initialize(){
        // Load employees from the database when UI starts
        lv_list.setItems(EmployeeDAO.loadEmployees());

        lv_list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                tf_employeename.setText(newValue.name);
                tf_hourlywage.setText(String.valueOf(newValue.wage));
                tf_hoursworked.setText(String.valueOf(newValue.hours));
                current = newValue;
            }
        });
    }

    public void onCalculateButtonClicked(ActionEvent actionEvent) {
        double wage = Double.parseDouble(tf_hourlywage.getText());
        double hours = Double.parseDouble(tf_hoursworked.getText());
        String name = tf_employeename.getText();
        double salary = hours*wage;

        salary_view.setText("SALARY: $" + String.format("%.2f", salary));
        salary_view.setVisible(true);
    }

    public void onSavePayroll(ActionEvent actionEvent) {
        double wage = Double.parseDouble(tf_hourlywage.getText());
        double hours = Double.parseDouble(tf_hoursworked.getText());
        String name = tf_employeename.getText();
        if(current == null){
            Employee e = new Employee(name, hours, wage);
            EmployeeDAO.insertEmployee(e);
            lv_list.getItems().add(e);
        }else{
            current.name = name;
            current.wage = wage;
            current.hours = hours;
            EmployeeDAO.updateEmployee(current);
            lv_list.refresh();
        }

        salary_view.setText("Saved to database");
    }

    public void onClearClicked(ActionEvent actionEvent) {
        salary_view.setText("");
        tf_hourlywage.clear();
        tf_hoursworked.clear();
        tf_employeename.clear();
        lv_list.getSelectionModel().clearSelection();
        current = null;
    }
}