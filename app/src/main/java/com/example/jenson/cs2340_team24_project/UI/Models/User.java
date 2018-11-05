package com.example.jenson.cs2340_team24_project.UI.Models;

import java.util.Arrays;
import java.util.List;

public class User {
    public static List<Responsibility> legalResponsibilities = Arrays.asList(Responsibility.values());

    protected String _email;
    protected String _username;
    protected Responsibility _res;
    protected boolean acctState;

    public User(String email, String username, Responsibility r) {
        _email = email;
        _username = username;
        _res = r;
        acctState = true;
    }

    public User(String email, String username, Responsibility r, boolean b) {
        _email = email;
        _username = username;
        _res = r;
        acctState = b;
    }

    //Responsibility setter and getter
    public void setResponsibility(Responsibility r) {
        this._res = r;
    }
    public Responsibility getResponsibility() {
        return this._res;
    }

    //Username setter and getter
    public void setUsername(String s) {
        this._username = s;
    }
    public String getUsername() {
        return _username;
    }

    //Email getter and setter
    public void setEmail(String s) {
        this._email = s;
    }
    public String getEmail() {
        return _email;
    }

    //Account state setter and getter
    public void setAcctState(boolean b) {
        this.acctState = b;
    }
    public boolean getAcctState() {
        return acctState;
    }
}
