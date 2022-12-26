package com.example.dailikart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EarnScreen extends AppCompatActivity {
    ImageView home, store, share, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earn_screen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        home = findViewById(R.id.home);

        store = findViewById(R.id.shop);
        share = findViewById(R.id.shared);
        profile = findViewById(R.id.profile);
        home.setOnClickListener(v -> {
            Intent intent = new Intent(EarnScreen.this, Dashboard.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });

        store.setOnClickListener(v -> {
            Intent intent = new Intent(EarnScreen.this, StoreScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
        share.setOnClickListener(v -> {
            Intent intent = new Intent(EarnScreen.this, ShareScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
        profile.setOnClickListener(v -> {
            Intent intent = new Intent(EarnScreen.this, ProfileScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(EarnScreen.this, Dashboard.class);
        startActivity(intent);
        overridePendingTransition(0, 0);

    }
}