package com.example.threadgui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private TextField tfNumbers;
    @FXML
    private TextField tfThreads;
    @FXML
    private TextArea taResults;
    @FXML
    private Button btnFind;
    @FXML
    private HBox hbUI;

    @FXML
    public void findPerfectNumber(){
        taResults.clear();
        hbUI.getChildren().clear();

        int num, threads;
        try{
            num = Integer.parseInt(tfNumbers.getText().trim());
            threads = Integer.parseInt(tfThreads.getText().trim());
            if(num <= 0 || threads <= 0) throw new NumberFormatException();
        }catch (NumberFormatException e){
            Platform.runLater(()-> taResults.setText("Invalid number"));
            return;
        }

        List<Integer> perfectNumbers = new ArrayList<>();
        List<Thread> threadList = new ArrayList<>();
        int chunksize = Math.max(1, num / threads);
        int start = 1;

        for(int i = 0; i < threads; i++){
            int end = Math.min(start + chunksize - 1, num);

            ProgressIndicator indicator = new ProgressIndicator();
            hbUI.getChildren().add(indicator);

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
            Platform.runLater(()-> taResults.appendText("Number of perfect numbers: " + perfectNumbers + "\n"));
        }).start();
    }
}
