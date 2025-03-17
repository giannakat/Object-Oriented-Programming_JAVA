package com.example.sphenicanswer.payroll;

import com.example.sphenicanswer.SphenicRunnable;
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
        lv_list.getFocusModel().focusedItemProperty().addListener(
                new ChangeListener<Employee>() {
                    @Override
                    public void changed(ObservableValue<? extends Employee> observableValue, Employee employee, Employee t1) {
                        // t1 is the new employee
                        //System.out.println(t1);
                        tf_employeename.setText(t1.name);
                        tf_hourlywage.setText(t1.wage + "");
                        tf_hoursworked.setText(t1.hours + "");

                        current = t1;


                    }
                }
        );
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
            lv_list.getItems().add(e);
        }else{
            current.name = name;
            current.wage = wage;
            current.hours = hours;

        }

    }

    public void onClearClicked(ActionEvent actionEvent) {
        salary_view.setVisible(false);
        tf_hourlywage.setText("");
        tf_hoursworked.setText("");
        tf_employeename.setText("");
        current = null;
    }
}
