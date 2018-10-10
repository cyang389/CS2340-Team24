package com.example.jenson.cs2340_team24_project.UI.Models;

import java.util.HashMap;

public class Database {
    private static HashMap<String, User> userinfo = new HashMap<String, User>(1000);
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
}
