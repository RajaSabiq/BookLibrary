package com.example.codingbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SelectionActivity extends AppCompatActivity {

    ImageButton registerHere, loginHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

        registerHere = findViewById(R.id.registerHere);
        loginHere = findViewById(R.id.loginHere);

        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regi = new Intent(SelectionActivity.this, RegisterActivity.class);
                startActivity(regi);
                finish();
            }
        });

        loginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logi = new Intent(SelectionActivity.this, LoginActivity.class);
                startActivity(logi);
                finish();
            }
        });
    }
}