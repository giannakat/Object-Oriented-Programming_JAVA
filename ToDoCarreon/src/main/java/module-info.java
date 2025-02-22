module com.example.todocarreon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.todocarreon to javafx.fxml;
    exports com.example.todocarreon;
}