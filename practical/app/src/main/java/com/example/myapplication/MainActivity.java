package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView animationView;
    Button btn, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        animationView = findViewById(R.id.lottieAnimationView);
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.nextpage); // ✅ Fixed btn2 initialization

        // Handle window insets
        View mainView = findViewById(R.id.main);
        if (mainView != null) { // ✅ Prevent null crash
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        // Button 1 Click Event
        btn.setOnClickListener(view -> {
            animationView.setVisibility(View.VISIBLE);
            animationView.playAnimation();
        });

        // Button 2 Click Event
        btn2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Calculator.class);
            startActivity(intent);
            finish();
        });
    }
}
