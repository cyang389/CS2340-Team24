package com.example.jenson.cs2340_team24_project.UI.Models;

public class Manager extends User {
    public Manager(String name, String pass) {
        super(name, pass, Responsibility.MANAGER);
    }
}
