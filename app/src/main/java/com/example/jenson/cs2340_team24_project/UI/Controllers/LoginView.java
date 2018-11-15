package com.example.jenson.cs2340_team24_project.UI.Controllers;

public interface LoginView {
    String getEmail();

    String getPassword();

    void setEmail(String resId);

    void setPassword(String resId);

    void showEmailError(int resId);

    void showPasswordError(int resId);

    void startMainActivity();

    void showLoginError();
}
