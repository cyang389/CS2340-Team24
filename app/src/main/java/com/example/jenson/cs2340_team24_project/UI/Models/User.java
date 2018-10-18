package com.example.jenson.cs2340_team24_project.UI.Models;

import java.util.Arrays;
import java.util.List;

public class User {
    public static List<Responsibility> legalResponsibilities = Arrays.asList(Responsibility.values());

    protected String _username;
    protected String _password;
    protected Responsibility _res;
    protected boolean acctState;
    protected String contactInfo;

    public User(String username, String password, Responsibility r) {
        _username = username;
        _password = password;
        _res = r;
    }

    public User(String username, String password) {
        this(username, password, Responsibility.USER);
    }

    //Responsibility setter and getter
    public void setResponsibility(Responsibility r) {
        this._res = r;
    }
    public Responsibility getResponsibility() {
        return this._res;
    }

    //Password setter and getter
    public void setPassword(String pass) {
        this._password = pass;
    }
    public String getPassword() {
        return this._password;
    }

    //Username setter and getter
    public void setUsername(String name) {
        this._username = name;
    }
    public String getUsername() {
        return this._username;
    }
}
