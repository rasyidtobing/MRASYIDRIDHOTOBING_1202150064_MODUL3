package com.example.android.mrasyidridhotobing_1202150064_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText vUser, vPassword;
    private Button vButton;

    //String yang berisikan username dan password
    private String username = "EAD";
    private String password = "MOBILE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toast.makeText(this, "Welcome!!", Toast.LENGTH_LONG);

        //mengambil ID dari view
        vUser = (EditText) findViewById(R.id.username);
        vPassword = (EditText) findViewById(R.id.password);
        vButton = (Button) findViewById(R.id.button_login);

    }


    public void login(View view) {
        if (valueLogin()) { // jika true maka activity berpindah ke MenuActivity
            Intent newAct = new Intent(this, MenuActivity.class);
            startActivity(newAct);
        } else { // jika salah makan akan memunculkan toast "Invalid Username"
            Toast.makeText(this, "Invalid Username", Toast.LENGTH_SHORT).show();
        }
    }

    //method untuk pengecekan username dan password benar atau salah
    public boolean valueLogin() {
        boolean login;

        if (vUser.getText().toString().equals(username) && vPassword.getText().toString().equals(password)) {
            login = true;
        } else {
            login = false;
        }
        return login;
    }
}
