package com.excelreader.activies;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.excelreader.R;

public class SplashActivity extends AppCompatActivity {

    private Animation fromBottom;

    private Animation fromTop;

    private LinearLayout logo;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        fromTop = AnimationUtils.loadAnimation(this, R.anim.from_top);

        ProgressBar progressBar = findViewById(R.id.progress_bar);
        logo = findViewById(R.id.logo);
        progressBar.setIndeterminateTintList(ColorStateList.valueOf(Color.parseColor("#65a844")));
        logo.setAnimation(fromTop);
        progressBar.setAnimation(fromBottom);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 3000);
    }
}
