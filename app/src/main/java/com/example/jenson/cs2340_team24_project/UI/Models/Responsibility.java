package com.example.jenson.cs2340_team24_project.UI.Models;

public enum Responsibility {
    USER("user"),
    LOCATION_EMPLOYEE("employee"),
    ADMIN("admin");

    private final String responsibility;
    Responsibility(String r) {
        this.responsibility = r;
    }
    public String getResponsibility() {
        return responsibility;
    }
}
