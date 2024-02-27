package com.example.codingbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText edt_email, edt_password;
    private Button loginbtn;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_email = findViewById(R.id.email);
        edt_password = findViewById(R.id.password);
        loginbtn = findViewById(R.id.login);

        firebaseAuth = FirebaseAuth.getInstance();
        loginbtn.setOnClickListener(view -> loginUser());

    }

    private void loginUser() {
        String email = edt_email.getText().toString().trim();
        String password = edt_password.getText().toString().trim();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Login success
                        Toast.makeText(LoginActivity.this, "Login Successful",
                                Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                        // Redirect to another activity or perform necessary action
                    } else {
                        // Login failed
                        Toast.makeText(LoginActivity.this, "Login Failed",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}