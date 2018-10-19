package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jenson.cs2340_team24_project.R;
import com.example.jenson.cs2340_team24_project.UI.Models.Database;
import com.example.jenson.cs2340_team24_project.UI.Models.Donation;

public class DetailDonationActivity extends AppCompatActivity {
    private Donation donation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_donation);
        getIncomingIntent();
        setInfo(donation);
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("donation_name")) {
            String name = getIntent().getStringExtra("donation_name");
            donation = Database.getDonations().get(name);
        }
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
        location.setText("Location: " + donation.getLocation().getName());
        shortDescription.setText("Short Description: " + donation.getShortDescription());
        fullDescription.setText("Full Description: " + donation.getFullDescription());
        value.setText("Value: " + donation.getValue());
        category.setText("Category: " + donation.getType());
        comments.setText("Comments: " + donation.getComments());
    }
}
