package com.example.jenson.cs2340_team24_project.UI.Models;

public class Manager extends User {
    public Manager(String email, String username) {
        super(email, username, Responsibility.MANAGER);
    }
}
