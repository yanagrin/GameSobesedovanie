package com.example.fragmentsnavigation;

import android.util.Log;

public class EndTest {
    int test_results=-1;
    int summa_ballov=0;
    public int doo(String ans_on_q1, String ans_on_q2, String ans_on_q3, String ans_on_q4, String ans_on_q5){
        int q1 = Integer.parseInt(ans_on_q1);
        int q2 = Integer.parseInt(ans_on_q2);
        int q3 = Integer.parseInt(ans_on_q3);
        int q4 = Integer.parseInt(ans_on_q4);
        int q5 = Integer.parseInt(ans_on_q5);

        summa_ballov = q1+q2+q3+q4+q5;
        if (summa_ballov>25){
            test_results=1;
        }
        else {test_results=0;}

        Log.d("END", " "+summa_ballov);
        return test_results;
    }
}
