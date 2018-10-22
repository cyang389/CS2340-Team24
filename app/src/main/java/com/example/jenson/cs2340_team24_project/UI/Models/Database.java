package com.example.jenson.cs2340_team24_project.UI.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Database {
    private static List<String> legalLocations = new ArrayList<>();

    public Database() {
    }
    public static void addLocation(Location l) {
        legalLocations.add(l.getName());
    }
    public static List<String> getLegalLocations() {
        return legalLocations;
    }
}
