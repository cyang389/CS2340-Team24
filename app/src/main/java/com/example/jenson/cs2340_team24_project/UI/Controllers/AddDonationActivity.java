package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jenson.cs2340_team24_project.R;
import com.example.jenson.cs2340_team24_project.UI.Models.Database;
import com.example.jenson.cs2340_team24_project.UI.Models.Donation;
import com.example.jenson.cs2340_team24_project.UI.Models.DonationType;
import com.example.jenson.cs2340_team24_project.UI.Models.Location;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AddDonationActivity extends AppCompatActivity {
    private Location location;
    private Donation donation;
    private Timestamp timeStamp;
    private String stringLocation;
    private String shortDescription;
    private String fullDescription;
    private double value;
    private String comments;
    private EditText mTimeStamp;
    private EditText mShortDescription;
    private EditText mFullDescription;
    private EditText mValue;
    private EditText mComment;
    private Spinner sLocation;
    private Spinner sCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donation);
        mTimeStamp = (EditText) findViewById(R.id.timeStampEditText);
        mShortDescription = (EditText) findViewById(R.id.shortDescriptionEditText);
        mFullDescription = (EditText) findViewById(R.id.fullDescriptionEditText);
        mValue = (EditText) findViewById(R.id.valueEditText);
        mComment = (EditText) findViewById(R.id.commentEditText);
        sLocation = (Spinner) findViewById(R.id.locationSpinner);
        sCategory = (Spinner) findViewById(R.id.categorySpinner);
        getIncomingIntent();

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,
                Database.getLegalLocations());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sLocation.setAdapter(adapter);
        sLocation.setSelection(Database.findLocation(location.getName()));

        ArrayAdapter<String> adapter1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,
                new ArrayList<DonationType>(Database.getLegalTypes()));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sCategory.setAdapter(adapter1);


        final Button addButton = (Button) findViewById(R.id.addButton);
        final Button cancelButton = (Button) findViewById(R.id.addDonationCancel);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = mTimeStamp.getText().toString();

                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date parsedDate = dateFormat.parse(a);
                    timeStamp = new java.sql.Timestamp(parsedDate.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                shortDescription = mShortDescription.getText().toString();
                fullDescription = mFullDescription.getText().toString();
                String string = mValue.getText().toString();
                if (TextUtils.isEmpty(string)) {
                    addButton.setEnabled(false);
                }
                addButton.setEnabled(true);
                value = Double.parseDouble(mValue.getText().toString());
                comments = mComment.getText().toString();
                donation = new Donation(location, timeStamp, value);
                donation.setLocation((Location) Database.getLocations().get(sLocation.getSelectedItem()));
                donation.setType((DonationType) sCategory.getSelectedItem());
                donation.setComments(comments);
                donation.setFullDescription(fullDescription);
                donation.setShortDescription(shortDescription);
                location.addDonation(donation);
                Database.addDonation(donation);
                Intent i = new Intent(AddDonationActivity.this, ViewDonationActivity.class);
                i.putExtra("location_name", location.getName());
                startActivity(i);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddDonationActivity.this, ViewDonationActivity.class);
                i.putExtra("location_name", location.getName());
                startActivity(i);
            }
        });
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("location_name")) {
            String name = getIntent().getStringExtra("location_name");
            location = Database.getLocations().get(name);
        }
    }
}
