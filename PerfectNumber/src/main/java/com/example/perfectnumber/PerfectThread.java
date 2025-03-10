package com.example.perfectnumber;


import javafx.application.Platform;
import javafx.scene.control.ProgressIndicator;

import java.util.List;

public class PerfectThread implements Runnable{
    private final int start;
    private final int end;
    private final List<Integer> perfectNumbers;
    private final ProgressIndicator indicator;
    private final HelloController controller;

    public PerfectThread(int start, int end, ProgressIndicator indicator, List<Integer> perfectNumbers, HelloController controller) {
        this.start = start;
        this.end = end;
        this.indicator = indicator;
        this.controller = controller;
        this.perfectNumbers = perfectNumbers;
    }

    @Override
    public void run() {
        int total = end - start + 1;
        int ctr = 0;
        for(int i = start; i <= end; i++){
            if(isPerfect(i)){
                synchronized (perfectNumbers){
                    perfectNumbers.add(i);
                }
            }
            ctr++;
            double progress = (double)ctr/total;
            Platform.runLater(()-> indicator.setProgress(progress));
        }
        Platform.runLater(()-> indicator.setProgress(1.0));
    }

    public boolean isPerfect(int num){
        int sum = 1;
        for(int i = 2; i <= num/2 ; i++){
            if(num % i == 0) sum += i;
        }
        return num == sum;
    }
}

//
//public int getDeficientCount() {
//    return deficientCount;
//}
//
//public int getAbundantCount() {
//    return abundantCount;
//}



//new Thread(() -> {
//        for (PerfectThread worker : workers) {
//        try {
//        worker.join();
//        } catch (InterruptedException e) {
//        e.printStackTrace();
//        }
//
//// Sum up the deficient and abundant numbers from each worker
//totalDeficient += worker.getDeficientCount();
//totalAbundant += worker.getAbundantCount();
//    }
//
//            Platform.runLater(() -> ta_result.appendText(
//        "Perfect numbers: " + perfectNumbers + "\n" +
//        "Deficient count: " + totalDeficient + "\n" +
//        "Abundant count: " + totalAbundant + "\n"
//));
//        }).start();




//@Override
//public void run() {
//    int total = end - start + 1;
//    int ctr = 0;
//
//    for (int i = start; i <= end; i++) {
//        int sum = sumOfDivisors(i);
//
//        if (sum == i) { // Perfect number
//            synchronized (perfectNumbers) {
//                perfectNumbers.add(i);
//            }
//        } else if (sum < i) { // Deficient number
//            synchronized (deficientNumbers) {
//                deficientNumbers.add(i);
//            }
//        } else { // Abundant number
//            synchronized (abundantNumbers) {
//                abundantNumbers.add(i);
//            }
//        }
//
//        ctr++;
//        double progress = (double) ctr / total;
//        Platform.runLater(() -> indicator.setProgress(progress));
//    }
//
//    Platform.runLater(() -> indicator.setProgress(1.0));
//}