package com.example.projektandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Rejestracja extends AppCompatActivity {

    EditText loginRegisterEditText, passwordRegisterEditText, repasswordEditText;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);

        loginRegisterEditText = findViewById(R.id.loginlRegisterEditText);
        passwordRegisterEditText = findViewById(R.id.passwordRegisterEditText);
        repasswordEditText = findViewById(R.id.repasswordRegisterEditText);

        db = new DBHelper(this);
    }

    public void zarejestruj(View view) {
        String login = loginRegisterEditText.getText().toString();
        String password = passwordRegisterEditText.getText().toString();
        String repass = repasswordEditText.getText().toString();


        if (login.equals("") || password.equals("") || repass.equals("")) {
            Toast.makeText(Rejestracja.this, "Uzupełnij rubryki", Toast.LENGTH_SHORT).show();
        } else {
            if (password.equals(repass)) {
                Boolean checkuser = db.checkLogin(login);
                if (!checkuser) {
                    Boolean insert = db.insertData(login, password);
                    if (insert) {
                        Toast.makeText(Rejestracja.this, "Zarejestrowano pomyślnie", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Rejestracja.this, MainActivity.class);
                        intent.putExtra("login",login);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Rejestracja.this, "Wystąpił błąd", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                Toast.makeText(Rejestracja.this, "Hasła nie są te same!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
