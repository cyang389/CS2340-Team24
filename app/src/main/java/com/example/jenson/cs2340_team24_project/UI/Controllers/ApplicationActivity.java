package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jenson.cs2340_team24_project.R;

import com.example.jenson.cs2340_team24_project.UI.Models.Database;
import com.example.jenson.cs2340_team24_project.UI.Models.Location;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ApplicationActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        readCSVFile();

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            Intent i = new Intent(ApplicationActivity.this, LoginActivity.class);
            Toast.makeText(ApplicationActivity.this, "No user is logged in.", Toast.LENGTH_LONG).show();
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();



        btnLogout = findViewById(R.id.button3);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                Intent i = new Intent(ApplicationActivity.this, HomeActivity.class);
                startActivity(i);
                Toast.makeText(ApplicationActivity.this, "You are logged out.", Toast.LENGTH_LONG).show();
            }
        });

        Button viewLocationButton = (Button) findViewById(R.id.button4);
        viewLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ApplicationActivity.this, ViewLocationActivity.class);
                startActivity(i);
            }
        });

        Button searchDonation = (Button) findViewById(R.id.applicationSearchDonation);
        searchDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ApplicationActivity.this, SearchDonationActivity.class);
                startActivity(i);
            }
        });
    }

    private void logOut() {
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
