package com.example.payroll;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.Optional;

public class HRController {


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
        lv_list.setItems(EmployeeCRUD.loadEmployees());

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
            EmployeeCRUD.insertEmployee(e);
            lv_list.getItems().add(e);
        }else{
            current.name = name;
            current.wage = wage;
            current.hours = hours;
            EmployeeCRUD.updateEmployee(current);
            lv_list.refresh();
        }
        lv_list.getSelectionModel().clearSelection();
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

    public void onDeleteClicked(ActionEvent actionEvent){
       if(!showDeleteConfirmation()){
           System.out.println("Deletion canceled");
           return;
       }

        Employee selectedEmployee = lv_list.getSelectionModel().getSelectedItem();

        if (selectedEmployee != null) {
            // Remove from database
            EmployeeCRUD.deleteEmployee(selectedEmployee.id);

            // Remove from ListView
            lv_list.getItems().remove(selectedEmployee);

            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("No employee selected!");
        }
    }

    public static boolean showDeleteConfirmation(){
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("DELETE");
        a.setHeaderText("Are you sure you want to delete this employee?");
        a.setContentText("This action cannot be undone.");

        Optional<ButtonType> result = a.showAndWait();

        return result.isPresent() && result.get() == ButtonType.OK;
    }
}