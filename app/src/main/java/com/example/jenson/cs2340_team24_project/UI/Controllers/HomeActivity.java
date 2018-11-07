package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jenson.cs2340_team24_project.R;

/**
 * Welcome Page
 */
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button btnLogin = findViewById(R.id.btnWelcomeLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        Button btnRegister = findViewById(R.id.btnWelcomeRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
