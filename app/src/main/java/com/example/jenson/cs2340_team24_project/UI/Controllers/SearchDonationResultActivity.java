package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jenson.cs2340_team24_project.R;
import com.example.jenson.cs2340_team24_project.UI.Models.Database;
import com.example.jenson.cs2340_team24_project.UI.Models.Donation;
import com.example.jenson.cs2340_team24_project.UI.Models.DonationType;
import com.example.jenson.cs2340_team24_project.UI.Models.Location;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SearchDonationResultActivity extends AppCompatActivity {
    private String name;
    private String location;
    private DonationType category;
    private ArrayList<String> donations = new ArrayList<>();

    private DatabaseReference databaseLocations;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donation_result);
        databaseLocations = FirebaseDatabase.getInstance().getReference("donations");
        getIncomingIntent();

    }

    private void getIncomingIntent() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = (String) extras.get("name");
            location = (String) extras.get("location");
            category = (DonationType) extras.get("category");
        }
    }

    /**
    @Override
    protected void onStart() {
        super.onStart();
        ValueEventListener donationListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                donations.clear();
                for (DataSnapshot donationSnapshot : dataSnapshot.getChildren()) {
                    Donation d = donationSnapshot.getValue(Donation.class);
                    if (location.equals("ALL LOCATION")) {
                        if (category == DonationType.NOTYPE) {
                            donations.add(d.getShortDescription());
                        } else {
                            if (d.getType().equals(category)) {
                                donations.add(d.getShortDescription());
                            }
                        }
                    } else {
                        if (d.getLocation().equals(location)) {
                            if (category == DonationType.NOTYPE) {
                                donations.add(d.getShortDescription());
                            } else {
                                if (d.getType().equals(category)) {
                                    donations.add(d.getShortDescription());
                                }
                            }
                        }
                    }
                }
                //initRecyclerView();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        databaseLocations.addValueEventListener(donationListener);
    }
    */

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, donations);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
