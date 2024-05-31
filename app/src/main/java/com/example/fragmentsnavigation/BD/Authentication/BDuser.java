package com.example.fragmentsnavigation.BD.Authentication;

public class BDuser {
    public String email="";
    public int q_of_tests=0;
    public String profession_on_last_try="";
    public int ball_on_last_try=0;
    public void ball_on_last_try(int ball_on_last_try) {
        this.ball_on_last_try = ball_on_last_try;
    }

    public BDuser(String email, int q_of_tests, String profession_on_last_try, int ball_on_last_try) {
        this.email = email;
        this.q_of_tests = q_of_tests;
        this.profession_on_last_try = profession_on_last_try;
        this.ball_on_last_try = ball_on_last_try;
    }
}
