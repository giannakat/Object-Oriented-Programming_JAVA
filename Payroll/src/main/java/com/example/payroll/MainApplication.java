package com.example.payroll;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            Parent fxmlLoader = FXMLLoader.load(getClass().getResource("login-view.fxml"));
            Scene scene = new Scene(fxmlLoader, 500, 700);
            stage.setResizable(false);
            stage.setTitle("Payroll");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}