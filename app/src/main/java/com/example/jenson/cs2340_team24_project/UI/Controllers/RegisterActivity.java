package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jenson.cs2340_team24_project.R;
import com.example.jenson.cs2340_team24_project.UI.Models.Database;
import com.example.jenson.cs2340_team24_project.UI.Models.Responsibility;
import com.example.jenson.cs2340_team24_project.UI.Models.User;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private EditText mPasswordView;
    private EditText mUsername;
    private Button btnRegister;
    private Button btnCancel;
    private Spinner responsibilitySpinner;

    private String uName;
    private String uPass;
    private Responsibility uRes;
    private User newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // set up the register form

        mUsername = findViewById(R.id.userNameReg);
        mPasswordView = findViewById(R.id.passWordReg);

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                uName = mUsername.getText().toString();
                uPass = mPasswordView.getText().toString();
                uRes = (Responsibility) responsibilitySpinner.getSelectedItem();
                newUser = new User(uName, uPass, uRes);
                Database.addUser(uName, newUser);
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                Toast.makeText(RegisterActivity.this, "You are successfully registered. Please Login.", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel = findViewById(R.id.btnCancelReg);
        btnCancel.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });

        responsibilitySpinner = findViewById(R.id.spinResponsibility);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, User.legalResponsibilities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        responsibilitySpinner.setAdapter(adapter);

    }
}
