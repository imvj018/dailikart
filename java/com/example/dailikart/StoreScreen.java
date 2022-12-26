package com.example.dailikart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class StoreScreen extends AppCompatActivity {
    ImageView home, earn, share, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_screen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        home = findViewById(R.id.home);
        earn = findViewById(R.id.earn);

        share = findViewById(R.id.shared);
        profile = findViewById(R.id.profile);
        home.setOnClickListener(v -> {
            Intent intent = new Intent(StoreScreen.this, Dashboard.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
        earn.setOnClickListener(v -> {
            Intent intent = new Intent(StoreScreen.this, EarnScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });

        share.setOnClickListener(v -> {
            Intent intent = new Intent(StoreScreen.this, ShareScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
        profile.setOnClickListener(v -> {
            Intent intent = new Intent(StoreScreen.this, ProfileScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(StoreScreen.this, Dashboard.class);
        startActivity(intent);
        overridePendingTransition(0, 0);

    }
}