package com.example.fragmentsnavigation.BD.Authentication;

public interface LoginCallback {
    void onLoginSuccess();
    void onLoginFailure(String errorMessage);
}
