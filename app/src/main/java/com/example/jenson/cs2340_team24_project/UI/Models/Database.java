package com.example.jenson.cs2340_team24_project.UI.Models;

import java.util.HashMap;

public class Database {
    private static HashMap<String, User> userinfo = new HashMap<String, User>(1000);
    private static HashMap<String, Location> locations = new HashMap<>();
    //donation information
    //location information

    public Database() {
    }

    public static void addUser(String username, User user) {
        userinfo.put(username, user);
    }

    public static User getUser(String name) {
        return userinfo.get(name);
    }

    public static boolean isEmpty() {
        return userinfo.isEmpty();
    }

    public static void addLocation(Location l) { locations.put(l.getName(), l); }

    public static HashMap<String, Location> getLocations() { return locations; }

    public static Location getLocation(String name) { return locations.get(name); }
}
