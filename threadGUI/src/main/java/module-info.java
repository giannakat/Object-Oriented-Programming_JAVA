module com.example.threadgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.threadgui to javafx.fxml;
    exports com.example.threadgui;
}