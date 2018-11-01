package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.jenson.cs2340_team24_project.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng afd = new LatLng(33.75416, -84.37742);
        mMap.addMarker(new MarkerOptions().position(afd).title("Marker in AFD"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(afd));
    }
}
