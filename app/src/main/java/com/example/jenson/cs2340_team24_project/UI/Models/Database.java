package com.example.jenson.cs2340_team24_project.UI.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Database {
    private static HashMap<String, User> userinfo = new HashMap<String, User>(1000);
    private static HashMap<String, Location> locations = new HashMap<>();
    private static HashMap<String, Donation> donations = new HashMap<>();
    private static List<DonationType> legalTypes = Arrays.asList(DonationType.values());
    private static List<String> legalLocations = new ArrayList<>();
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

    public static void addLocation(Location l) {
        locations.put(l.getName(), l);
        legalLocations.add(l.getName());
    }

    public static HashMap<String, Location> getLocations() { return locations; }


    public static Location getLocation(String name) { return locations.get(name); }

    public static List<DonationType> getLegalTypes() {
        return legalTypes;
    }

    public static HashMap<String, Donation> getDonations() {
        return donations;
    }

    public static void addDonation(Donation donation) {
        donations.put(donation.getShortDescription(), donation);
    }

    public static List<String> getLegalLocations() {
        return legalLocations;
    }

    public static int findLocation(String code) {
        legalLocations = new ArrayList<String>(locations.keySet());
        int i = 0;
        while (i < legalLocations.size()) {
            if (code.equals(legalLocations.get(i))) return i;
            ++i;
        }
        return 0;
    }
}
