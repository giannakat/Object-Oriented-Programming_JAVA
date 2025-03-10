module com.example.gizmo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gizmo to javafx.fxml;
    exports com.example.gizmo;
}