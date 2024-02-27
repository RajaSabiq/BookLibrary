package com.example.codingbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText edt_email, edt_password;
    private Button register;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edt_email = findViewById(R.id.email);
        edt_password = findViewById(R.id.password);
        register = findViewById(R.id.login);
        
        firebaseAuth = FirebaseAuth.getInstance();
        register.setOnClickListener(view -> registerUser());

    }
    private void registerUser() {
        String email = edt_email.getText().toString().trim();
        String password = edt_password.getText().toString().trim();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Registration success
                        Toast.makeText(RegisterActivity.this, "Registration Successful",
                                Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                        // Redirect to another activity or perform necessary action
                    } else {
                        // Registration failed
                        Toast.makeText(RegisterActivity.this, "Registration Failed",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}