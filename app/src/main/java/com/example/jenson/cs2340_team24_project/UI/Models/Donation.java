package com.example.jenson.cs2340_team24_project.UI.Models;

public class Donation {
    private String location;
    private String shortDescription;
    private String fullDescription;
    private double value;
    private String comments;
    private String time;
    private DonationType type = DonationType.OTHER;

    public Donation(String location, String shortDescription, String fullDescription,
                    Double value, String comments, DonationType type, String time) {
        this.location = location;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.value = value;
        this.comments = comments;
        this.type = type;
        this.time = time;
    }

    public Donation() {}

    //Setters and getters
    public String getLocation() {
        return location;
    }
    public void setLocation(String l) {
        this.location = l;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String s) {
        this.shortDescription = s;
    }
    public String getFullDescription() {
        return fullDescription;
    }
    public void setFullDescription(String s) {
        this.fullDescription = s;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double v) {
        this.value = v;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String s) {
        this.comments = s;
    }
    public String getDonationTime() {
        return time;
    }
    public void setDonationTime(String t) {
        this.time = t;
    }
    public void setType(DonationType type) {
        this.type = type;
    }
    public DonationType getType() {
        return type;
    }
}
