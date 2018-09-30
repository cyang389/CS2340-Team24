package com.example.jenson.cs2340_team24_project.UI.Models;

import java.util.Arrays;
import java.util.List;

public class User {
    public static List<Responsibility> legalResponsibilities = Arrays.asList(Responsibility.values());

    private String _username;
    private String _password;
    private Responsibility _res;

    public User(String username, String password, Responsibility r) {
        _username = username;
        _password = password;
        _res = r;
    }

    public User(String username, String password) {
        this(username, password, Responsibility.USER);
    }
}
