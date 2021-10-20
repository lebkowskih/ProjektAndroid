package com.example.projektandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class logowanie extends AppCompatActivity {

    EditText emailEditText,passwordEditText;
    Button loginButton;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);
    }

    public void logowanie1(View view){
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        db = new DBHelper(this);
        String mail = emailEditText.getText().toString();
        String pass = passwordEditText.getText().toString();
        if(mail.equals("") || pass.equals("")||)
            Toast.makeText(logowanie.this,"Wypełnij wszystkie rubryki",Toast.LENGTH_SHORT).show();
        else{
            if (pass.equals)
        }


    }
}