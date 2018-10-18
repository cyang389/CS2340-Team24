package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.jenson.cs2340_team24_project.R;
import com.example.jenson.cs2340_team24_project.UI.Models.Database;
import com.example.jenson.cs2340_team24_project.UI.Models.Donation;
import com.example.jenson.cs2340_team24_project.UI.Models.Location;

import java.util.ArrayList;

public class ViewDonationActivity extends AppCompatActivity {

    private Location location;
    private ArrayList<String> donations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_donation);
        getIncomingIntent();
        ArrayList<Donation> donationArrayList = location.getDonations();
        if (donationArrayList != null) {
            for (int i = 0; i < donationArrayList.size(); i++) {
                String name = donationArrayList.get(i).getName();
                donations.add(name);
            }
        }
        if (donations != null) {
            initRecyclerView();
        }
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("location_name")) {
            String name = getIntent().getStringExtra("location_name");
            location = Database.getLocations().get(name);
        }
    }


    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, donations);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
