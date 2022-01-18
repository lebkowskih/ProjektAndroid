package com.example.projektandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class EkranStartowy extends AppCompatActivity {

    Animation bottom_animation;
    TextView titleofapp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ekranstartowy);
        bottom_animation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        titleofapp = findViewById(R.id.titleofapp);
        titleofapp.setAnimation(bottom_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(EkranStartowy.this, Logowanie.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}