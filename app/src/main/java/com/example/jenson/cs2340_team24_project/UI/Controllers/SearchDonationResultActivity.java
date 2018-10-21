package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jenson.cs2340_team24_project.R;
import com.example.jenson.cs2340_team24_project.UI.Models.Database;
import com.example.jenson.cs2340_team24_project.UI.Models.DonationType;

public class SearchDonationResultActivity extends AppCompatActivity {
    private String name;
    private String location;
    private DonationType category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_donation_result);
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
}
