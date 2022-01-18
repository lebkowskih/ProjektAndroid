package com.example.projektandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Scene;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView helloText = findViewById(R.id.hiText);
        Bundle extras = getIntent().getExtras();
        helloText.setText("Witaj" + extras.getString("login"));
    }

}