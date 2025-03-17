package com.example.sphenicanswer;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.scene.control.ProgressIndicator;

public class SphenicRunnable implements Runnable{

    int start, end;
    ProgressIndicator pi;
    ObservableList<Integer> list;


    public SphenicRunnable(int start, int end, ProgressIndicator pi, ObservableList<Integer> list) {
        this.start = start;
        this.end = end;
        this.pi = pi;
        this.list = list;
    }

    @Override
    public void run() {


        for(int i = start; i <= end; i++){
            //how do u know it's sphenic?
            //42 / 2 = 21 / 3 = 7 / 7 = 1

            pi.setProgress((double)(i-start)/(end-start));
            if(isSphenic(i)){
                //System.out.println(i);
               list.add(i);
            }
        }
    }

    private boolean isSphenic(int num){
        int ctr = 0;
        int val = 2;
        int res = 0;
        //8/2 = 4 / 2 = 2 / 2 = 1

        while(num!=1 && ctr < 3){
            for(int i = 2; i <= num; i++){
                if(num % i==0){
                    ctr++;
                    num/=i;
                    if(num % i==0){
                        return false;
                    }
                    break;
                }
            }
        }


        return ctr == 3 && num==1;
    }
}
