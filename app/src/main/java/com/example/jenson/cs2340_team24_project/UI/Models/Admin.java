package com.example.jenson.cs2340_team24_project.UI.Models;

public class Admin extends User{
    public Admin(String name, String pass) {
        super(name, pass, Responsibility.ADMIN);
    }
}
