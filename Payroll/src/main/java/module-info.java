module com.example.payroll {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.payroll to javafx.fxml;
    exports com.example.payroll;
}