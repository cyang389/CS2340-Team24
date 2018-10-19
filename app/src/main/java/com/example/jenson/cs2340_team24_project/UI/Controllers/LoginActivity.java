package com.example.jenson.cs2340_team24_project.UI.Controllers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jenson.cs2340_team24_project.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final String REQUIRED = "Required";
    private EditText mPasswordField;
    private EditText mEmailField;
    private Button btnLogin;
    private Button btnCancel;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailField = findViewById(R.id.email);
        mPasswordField = findViewById(R.id.password);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        btnLogin = findViewById(R.id.email_sign_in_button);
        btnCancel = findViewById(R.id.button2);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
                Intent i = new Intent(LoginActivity.this, ApplicationActivity.class);
                startActivity(i);
            }
        });
    }

    private void attemptLogin() {
        String email = mEmailField.getText().toString().trim();
        String password = mPasswordField.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this,
                    "Please enter email to log in.",
                    Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this,
                    "Please enter password to log in.",
                    Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Logging in...");
        progressDialog.show();

        //showProgressDialog();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this,
                                    "You have logged in.",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(LoginActivity.this,
                                    "Login failed.",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
        progressDialog.hide();
    }
}

