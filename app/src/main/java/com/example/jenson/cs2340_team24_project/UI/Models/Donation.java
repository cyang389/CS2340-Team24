package com.example.jenson.cs2340_team24_project.UI.Models;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class Donation {
    private Location location;
    private String shortDescription;
    private String fullDescription;
    private double value;
    private String comments;
    private Timestamp time;
    private DonationType type = DonationType.OTHER;

    public Donation(Location l, Timestamp t, double v) {
        this.location = l;
        this.time = t;
        this.value = v;
    }

    //Setters and getters
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location l) {
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
    public Timestamp getDonationTime() {
        return time;
    }
    public void setDonationTime(Timestamp t) {
        this.time = t;
    }
    public void setType(DonationType type) {
        this.type = type;
    }
    public DonationType getType() {
        return type;
    }
}
