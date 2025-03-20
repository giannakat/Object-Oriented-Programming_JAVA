package com.example.payroll;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class LoginController {


    @FXML
  public TextField idnumber_tf;

    @FXML
    private Button login_button;

    @FXML
    private Label password_prompt;

    @FXML
    private PasswordField password_tf;

    @FXML
   private ComboBox<String> role_cb;

    @FXML
    private TextField username_tf;


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void initialize(){
        role_cb.getItems().addAll("Employee", "HR");
        role_cb.setValue("Employee");

        role_cb.setOnAction(event -> {
            if("HR".equals(role_cb.getValue())){
                password_tf.setPromptText("Enter HR Passcode");
                login_button.setText("Login as HR");
            }else{
                password_tf.setPromptText("Enter password");
            }
        });
    }

    @FXML
    public void login(ActionEvent event) throws IOException{
        String username = username_tf.getText();
        String password = password_tf.getText();
        String role = role_cb.getValue();
        if(authenticateUser(username, password, role)){
            switchScene(event, role.equals("HR") ? "hr-view.fxml" : "employee-view.fxml");
        }else{
            showAlert("Login Failed", "Invalid credentials. Please try again");
        }
    }

    private void switchScene(ActionEvent event, String file) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/payroll/" + file));
        root = loader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean authenticateUser(String username, String password, String role) {
        if(username == "" || password == ""){
            return false;
        }else return true;
    }
//
//    public void switchToLogin(ActionEvent event) throws IOException{
//        root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
//        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.show();
//    }
//
//    public void switchToMain(ActionEvent event) throws IOException{
//        root = FXMLLoader.load(getClass().getResource("hr-view.fxml"));
//        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
}
