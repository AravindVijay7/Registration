package com.example.aravind.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email,pass;
    Button log,can;

    SharedPreferences sharedpreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       // Intent l = getIntent();
/*        String name = l.getStringExtra("name");
        final String password = l.getStringExtra("Password");
        String Age = l.getStringExtra("Age");
        String Address = l.getStringExtra("Address");
        final String Email = l.getStringExtra("Email");
        String Contact = l.getStringExtra("Contact");
        String Place = l.getStringExtra("Place");
        String Gender = l.getStringExtra("Gender");
        String Qualification = l.getStringExtra("Qualification");*/
        sharedpreference = PreferenceManager.getDefaultSharedPreferences(this);

        final String Email = sharedpreference.getString("Em","");
        final String password = sharedpreference.getString("Password","");

        email = findViewById(R.id.mail);
        pass = findViewById(R.id.pass);

        log = findViewById(R.id.logb);
        can = findViewById(R.id.canb);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String email1 = email.getText().toString().trim();
                String passw = pass.getText().toString().trim();

                if (Email.equals(email1)&& password.equals(passw)){

                    Toast.makeText(Login.this, "Login Success :)", Toast.LENGTH_SHORT).show();
                    Intent  l = new Intent(getApplicationContext(),Home.class);
                    startActivity(l);
                }
                else {
                    Toast.makeText(Login.this, "Login Failed :(", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Toast.makeText(this, "name" + name + "password" + password + "Age" + Age + "Address" + Address + "email" + Email + "Contact" + Contact + "Place" + Place + "Gender" + Gender + "Qualification"  + Qualification, Toast.LENGTH_SHORT).show();
    }
}
