package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jenson.cs2340_team24_project.R;
import com.example.jenson.cs2340_team24_project.UI.Models.Database;
import com.example.jenson.cs2340_team24_project.UI.Models.Donation;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;


public class DetailDonationActivity extends AppCompatActivity {
    private Donation donation;
    private DatabaseReference databaseDonations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_donation);
        databaseDonations = FirebaseDatabase.getInstance().getReference("donations");
    }

    @Override
    protected void onStart() {
        super.onStart();
        ValueEventListener donationListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = getIntent().getStringExtra("donation_name");
                for (DataSnapshot donationSnapshot : dataSnapshot.getChildren()) {
                    Donation d = donationSnapshot.getValue(Donation.class);
                    if (d.getShortDescription().equals(name)) {
                        donation = d;
                        break;
                    }
                }
                setInfo(donation);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        databaseDonations.addValueEventListener(donationListener);
    }

    private void setInfo(Donation donation) {
        TextView time = findViewById(R.id.donationTime);
        TextView location = findViewById(R.id.donationLocation);
        TextView shortDescription = findViewById(R.id.donationShortDescription);
        TextView fullDescription = findViewById(R.id.donationFullDescription);
        TextView value = findViewById(R.id.donationValue);
        TextView category = findViewById(R.id.donationCategory);
        TextView comments = findViewById(R.id.donationComments);

        time.setText("Time: " + donation.getDonationTime());
        location.setText("Location: " + donation.getLocation());
        shortDescription.setText("Short Description: " + donation.getShortDescription());
        fullDescription.setText("Full Description: " + donation.getFullDescription());
        value.setText("Value: " + donation.getValue());
        category.setText("Category: " + donation.getType());
        comments.setText("Comments: " + donation.getComments());
    }
}
