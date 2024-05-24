package com.example.fragmentsnavigation;

public interface LoginCallback {
    void onLoginSuccess();
    void onLoginFailure(String errorMessage);
}
