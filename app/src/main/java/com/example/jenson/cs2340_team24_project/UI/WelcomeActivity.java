package com.example.jenson.cs2340_team24_project.UI;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.jenson.cs2340_team24_project.R;

public class WelcomeActivity extends AppCompatActivity {
    private static int Timeout = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(WelcomeActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },Timeout);
    }
}
