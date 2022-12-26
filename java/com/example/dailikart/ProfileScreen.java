package com.example.dailikart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ProfileScreen extends AppCompatActivity {
    ImageView home, earn, store, share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_screen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        home = findViewById(R.id.home);
        earn = findViewById(R.id.earn);
        store = findViewById(R.id.shop);
        share = findViewById(R.id.shared);

        home.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileScreen.this, Dashboard.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
        earn.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileScreen.this, EarnScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
        store.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileScreen.this, StoreScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
        share.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileScreen.this, ShareScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ProfileScreen.this, Dashboard.class);
        startActivity(intent);
        overridePendingTransition(0, 0);

    }
}