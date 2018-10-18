package com.example.jenson.cs2340_team24_project.UI.Models;

import java.util.ArrayList;

public class Location {
    private String name;
    private String type;
    private double longtitude;
    private double latitude;
    private String address;
    private String phone;
    private String website;
    private ArrayList<Donation> donations;
    public Location(String name, String type, double lontitude,
                    double latitude, String address, String phone, String website) {
        this.name = name;
        this.type = type;
        this.longtitude = lontitude;
        this.latitude = latitude;
        this.address = address;
        this.phone = phone;
        this.website = website;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public double getLongtitude() {
        return longtitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getWebsite() { return website; }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setWebsite(String website) { this.website = website; }
}
