package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jenson.cs2340_team24_project.R;
import com.example.jenson.cs2340_team24_project.UI.Models.Database;
import com.example.jenson.cs2340_team24_project.UI.Models.Location;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DetailLocationActivity extends AppCompatActivity {

    private ArrayList<String> mList;
    private Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_location);
        getIncomingIntent();
        setInfo(location);
        Button viewDonations = findViewById(R.id.button7);
        viewDonations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailLocationActivity.this, ViewDonationActivity.class);
                i.putExtra("location_name", location.getName());
                startActivity(i);
            }
        });
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("location_name")) {
            String name = getIntent().getStringExtra("location_name");
            location = Database.getLocations().get(name);
        }
    }

    private void setInfo(Location location) {
        TextView name = findViewById(R.id.name);
        TextView type = findViewById(R.id.type);
        TextView longitude = findViewById(R.id.longtitude);
        TextView latitude = findViewById(R.id.latitude);
        TextView address = findViewById(R.id.address);
        TextView phone = findViewById(R.id.phone);
        TextView website = findViewById(R.id.website);

        name.setText("Name: " + location.getName());
        type.setText("Type: " + location.getType());
        longitude.setText("Longitude: " + location.getLongtitude());
        latitude.setText("Latitude: " + location.getLatitude());
        address.setText("Address: " + location.getAddress());
        phone.setText("Phone: " + location.getPhone());
        website.setText("Website: " + location.getWebsite());
    }
}
