package com.example.aravind.test;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView namet,aget,qualt,addt,gent,mailt,mobt,plct;
    SharedPreferences spt;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        spt = PreferenceManager.getDefaultSharedPreferences(this);




        namet = findViewById(R.id.name);
        aget = findViewById(R.id.age);
        qualt = findViewById(R.id.quali);
        addt = findViewById(R.id.address);
        gent = findViewById(R.id.gender);
        mailt = findViewById(R.id.email);
        mobt = findViewById(R.id.mno);
        plct = findViewById(R.id.place);

        final String name = spt.getString("name","");
        final String add = spt.getString("Address","");
        final String Email = spt.getString("Em","");
        final String age = spt.getString("Age","");
        final String contact = spt.getString("Contact","");
        final String place = spt.getString("Place","");
        final String gender = spt.getString("Gender","");
        final String qul = spt.getString("Qualification","");


        namet.setText(name);
        aget.setText(age);
        qualt.setText(qul);
        addt.setText(add);
        gent.setText(gender);
        mailt.setText(Email);
       mobt.setText(contact);
       plct.setText(place);




    }
}
