package com.example.sphenicanswer;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    public TextField tf_numbers;
    public TextField tf_threads;
    public Button btnOK;
    public ListView<Integer> lv_list;
    public HBox hb_progcontainer;

    @FXML
    public void onOKclick(ActionEvent actionEvent) {
        try{
            int num = Integer.parseInt(tf_numbers.getText());
            int thrd = Integer.parseInt(tf_threads.getText());
            List<Thread> threads = new ArrayList<>();
            int each = num/thrd;

            for(int i = 0; i < thrd; i++){
                ProgressIndicator pi = new ProgressIndicator();
                //we need to access the container
                hb_progcontainer.getChildren().add(pi);
                threads.add(new Thread(new SphenicRunnable(each*i+1, each*(i+1), pi, lv_list.getItems())));
            }

            for(Thread t : threads){
                t.start();
            }


        }catch (Exception e){
            Alert a = new Alert(Alert.AlertType.ERROR,e.toString(), ButtonType.OK);
            a.show();
            tf_numbers.setText("");
            tf_threads.setText("");
        }


    }


}