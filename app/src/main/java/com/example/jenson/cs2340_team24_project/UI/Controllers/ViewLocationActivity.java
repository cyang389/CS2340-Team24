package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.jenson.cs2340_team24_project.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.jenson.cs2340_team24_project.R;
import com.example.jenson.cs2340_team24_project.UI.Models.Database;
import com.example.jenson.cs2340_team24_project.UI.Models.Location;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewLocationActivity extends AppCompatActivity {

    private static final String TAG = "ViewLocationActivity";

    private ArrayList<String> mLocationNames = new ArrayList<>();

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_location);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        readCSVFile();
        initRecyclerView();

        HashMap<String, Location> locations = Database.getLocations();
        Button back = findViewById(R.id.viewLocationBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ViewLocationActivity.this, ApplicationActivity.class);
                startActivity(i);
            }
        });

    }


    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mLocationNames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
                mLocationNames.add(name);
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
                String encoded = encodeString(name);
                databaseReference.child("locations").child(encoded).setValue(l);
            }
        } catch (IOException e) {
            Log.e("ViewLocationActivity", "Error reading assets.");
        }
    }
    public static String decodeString(String s) {
        return s.replace(",", ".");
    }
    public static String encodeString(String s) {
        return s.replace(".", ",");
    }

}