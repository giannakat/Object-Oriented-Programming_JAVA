module com.example.sphenicanswer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sphenicanswer to javafx.fxml;
    exports com.example.sphenicanswer;

    opens com.example.sphenicanswer.payroll to javafx.fxml;
    exports com.example.sphenicanswer.payroll;
}