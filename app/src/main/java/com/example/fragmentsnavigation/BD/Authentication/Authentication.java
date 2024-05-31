package com.example.fragmentsnavigation.BD.Authentication;

import android.text.Editable;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Authentication {
    Integer okey =-10;
    public int check_email_and_password(Editable name, Editable pasw){
        String emailAddress = String.valueOf(name);
        String password = String.valueOf(pasw);
        String emailPattern = "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(emailAddress);

        if (password.length()>5 && emailAddress.contains("@") && matcher.matches()){

            return 1;
        }
        else{
            return 2;
        }
    }

    public void login_or_register(Editable name, Editable pasw, LoginCallback callback){
        String emailAddress = String.valueOf(name);
        String password = String.valueOf(pasw);

        FirebaseAuth.getInstance().signOut();

        Task<AuthResult> auth = FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailAddress, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            callback.onLoginSuccess();
                            Log.w("BBBregistr", "OK.", task.getException());
                        }
                        else {
                            Log.w("BBBregistr", "ERRor.", task.getException());
                        }
                    }
                });
        //FirebaseAuth.getInstance().signOut();
        FirebaseAuth auth1 = FirebaseAuth.getInstance();
        //auth1.signOut(); //выйти

        //FirebaseAuth auth1 = FirebaseAuth.getInstance();
        if (auth1.getCurrentUser() != null) {
            Log.w("BBBsignIn", "AlreadySignIn");
            //auth1.signOut();

        } else {
            auth1.signInWithEmailAndPassword(emailAddress, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                callback.onLoginSuccess();
                                Log.w("BBBsignIn", "OK. ", task.getException());
                            }
                            else {
                                Log.w("BBBsignIn", "ERROR.", task.getException());
                            }
                        }
                    });
        }
    }

    public void log_out(){

        FirebaseAuth auth1 = FirebaseAuth.getInstance();
        auth1.signOut();
        Log.w("BBBsignOUT", "IsOut");
    }



    String emailAddress = "111@mail.ru";
    String password = "000000";

    //emailAddress = "000@mail.ru";
    //password = "000000";


}
