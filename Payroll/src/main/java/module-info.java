module com.example.payroll {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.payroll to javafx.fxml;
    exports com.example.payroll;
}