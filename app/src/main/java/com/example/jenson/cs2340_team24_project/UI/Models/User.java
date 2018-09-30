package com.example.jenson.cs2340_team24_project.UI.Models;

import com.example.jenson.cs2340_team24_project.UI.RegisterActivity;

import java.util.Arrays;
import java.util.List;

public class User {
    public static List<Responsibility> legalResponsibilities = Arrays.asList(Responsibility.values());

    private String _username;
    private String _password;

    public User(String username, String password) {
        _username = username;
        _password = password;
    }
}
