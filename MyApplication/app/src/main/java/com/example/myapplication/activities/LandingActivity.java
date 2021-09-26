package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class LandingActivity extends AppCompatActivity {

    private CardView loginCard,registerCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        initialiseWidgets();
        loginCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        registerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initialiseWidgets() {
        loginCard = findViewById(R.id.loginCard);
        registerCard = findViewById(R.id.registerCard);
    }
}