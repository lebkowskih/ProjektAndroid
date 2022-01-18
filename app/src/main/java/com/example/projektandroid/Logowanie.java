package com.example.projektandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Logowanie extends AppCompatActivity {

    EditText loginEditText,passwordEditText;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);
        loginEditText = findViewById(R.id.loginEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        db = new DBHelper(this);

    }


    public void zaloguj(View view){
        String login = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(login.equals("")|| password.equals("")){
            Toast.makeText(Logowanie.this,"Proszę wypełnić rubryki",Toast.LENGTH_SHORT).show();
        }

        else{
            Boolean checkLoginPassword = db.checkLoginPassword(login,password);
            if(checkLoginPassword){
                Intent intent = new Intent(Logowanie.this,MainActivity.class);
                intent.putExtra("login",login);
                startActivity(intent);
                }
            else{
                    Toast.makeText(Logowanie.this,"Podałeś złe hasło",Toast.LENGTH_SHORT).show();
                }
            }
            }


    public void registerclick(View view){
        Intent intent = new Intent(Logowanie.this, Rejestracja.class);
        startActivity(intent);
    }
        }



