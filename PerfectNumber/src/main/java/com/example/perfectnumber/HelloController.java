package com.example.perfectnumber;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    public TextField tf_thread_count;
    public TextField tf_number;
    public TextArea ta_result;
    public HBox hb_progress;
    public Button btn_find;

    @FXML
    public void findPerfectNumber(){
        ta_result.clear();
        hb_progress.getChildren().clear();

        int num, threads;

        try{
            num = Integer.parseInt(tf_number.getText().trim());
            threads = Integer.parseInt(tf_thread_count.getText().trim());
            if(num <= 0 || threads <= 0) throw new NumberFormatException();
        }catch (NumberFormatException e){
            Platform.runLater(()->ta_result.setText("Invalid number"));
            return;
        }

        List<Integer> perfectNumbers = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();
        int chunksize = Math.max(1, num / threads);
        int start = 1;

        for(int i = 0; i < threads; i++){
            int end = Math.min(start + chunksize - 1, num);

            ProgressIndicator indicator = new ProgressIndicator();
            hb_progress.getChildren().add(indicator);

            PerfectThread worker = new PerfectThread(start, end, indicator, perfectNumbers, this);
            Thread thread = new Thread(worker);
            thread.start();

            threadList.add(thread);
            start = end + 1;
        }

        new Thread (() -> {
            for(Thread t : threadList){
                try{
                    t.join();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            Platform.runLater(()-> ta_result.appendText("Number of perfect numbers: " + perfectNumbers + "\n"));
        }).start();
    }

}