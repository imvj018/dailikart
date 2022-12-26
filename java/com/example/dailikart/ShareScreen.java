package com.example.dailikart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class ShareScreen extends AppCompatActivity {
    ImageView home, earn, store, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_screen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        home = findViewById(R.id.home);
        earn = findViewById(R.id.earn);
        store = findViewById(R.id.shop);

        profile = findViewById(R.id.profile);
        home.setOnClickListener(v -> {
            Intent intent = new Intent(ShareScreen.this, Dashboard.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
        earn.setOnClickListener(v -> {
            Intent intent = new Intent(ShareScreen.this, EarnScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
        store.setOnClickListener(v -> {
            Intent intent = new Intent(ShareScreen.this, StoreScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(ShareScreen.this, ProfileScreen.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ShareScreen.this, Dashboard.class);
        startActivity(intent);
        overridePendingTransition(0, 0);

    }
}