package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.jenson.cs2340_team24_project.R;
import com.example.jenson.cs2340_team24_project.UI.Models.Database;
import com.example.jenson.cs2340_team24_project.UI.Models.Location;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class WelcomeActivity extends AppCompatActivity {
    private static int Timeout = 3500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        readCSVFile();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(WelcomeActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },Timeout);
    }

    private void readCSVFile() {
        try {
            InputStream is = getResources().openRawResource(R.raw.locationdata);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double latitude = Double.parseDouble(tokens[2]);
                double longitude = Double.parseDouble(tokens[3]);
                String address = tokens[4];
                String city = tokens[5];
                String state = tokens[6];
                int zip = Integer.parseInt(tokens[7]);
                String type = tokens[8];
                String phone = tokens[9];
                String website = tokens[10];
                Location l = new Location(name, type, longitude, latitude, address, phone, website);
                Database.addLocation(l);
            }
        } catch (IOException e) {
            Log.e("ViewLocationActivity", "Error reading assets.");
        }
    }
}
