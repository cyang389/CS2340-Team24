package com.example.jenson.cs2340_team24_project.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.jenson.cs2340_team24_project.LoginActivity;
import com.example.jenson.cs2340_team24_project.R;

public class ApplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        Button logoutButton = (Button) findViewById(R.id.button3);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ApplicationActivity.this, HomeActivity.class);
                startActivity(i);
                Toast.makeText(ApplicationActivity.this, "You are logged out.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
