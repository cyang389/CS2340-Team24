package com.example.jenson.cs2340_team24_project.UI.Models;

public class Location {
    private String name;
    private String type;
    private String longtitude;
    private String latitude;
    private String address;
    private String phone;
    public Location(String name, String type, String lontitude,
                    String latitude, String address, String phone) {
        this.name = name;
        this.type = type;
        this.longtitude = lontitude;
        this.latitude = latitude;
        this.address = address;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public String getLongtitude() {
        return longtitude;
    }
    public String getLatitude() {
        return latitude;
    }
    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
