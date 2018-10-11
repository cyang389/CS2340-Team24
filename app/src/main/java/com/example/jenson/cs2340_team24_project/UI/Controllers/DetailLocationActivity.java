package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
        setImage(location);
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("location_name")) {
            String name = getIntent().getStringExtra("location_name");
            location = Database.getLocations().get(name);
        }
    }

    private void setImage(Location location) {
        TextView name = findViewById(R.id.name);
        name.setText(location.getName());
    }
}
