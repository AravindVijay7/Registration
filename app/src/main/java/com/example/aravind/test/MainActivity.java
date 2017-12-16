package com.example.aravind.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt_submit,bt_cancel;
    EditText name,age1,address,email,password,phno;
    RadioGroup rg;
    CheckBox cb10,cb12,cbbsc,cbbtch;
    Spinner place;
    String array[] ={"TVM","PLKD","KLM","KTYM"};
    AutoCompleteTextView langc;

    String languages[] = {"java","ios","android","c++","swift"};

    SharedPreferences sp;
    SharedPreferences.Editor editr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Registring", Toast.LENGTH_SHORT).show();
        name = findViewById(R.id.name);
        age1 = findViewById(R.id.age);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pword);
        phno = findViewById(R.id.mno);
        place = findViewById(R.id.place);

        langc = findViewById(R.id.lang);
        ArrayAdapter adap = new ArrayAdapter(this,android.R.layout.simple_list_item_1,languages);
        langc.setAdapter(adap);
        langc.setThreshold(2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp = PreferenceManager.getDefaultSharedPreferences(this);
        editr = sp.edit();

        place.setAdapter(adapter);

        rg = findViewById(R.id.gender);

        cb10 = findViewById(R.id.ten);
        cb12 = findViewById(R.id.tvel);
        cbbsc = findViewById(R.id.bsc);
        cbbtch = findViewById(R.id.btech);

        bt_cancel = findViewById(R.id.cancel);
        bt_submit = findViewById(R.id.submit);

         bt_submit.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String qualification ="";
                 String nameS = name.getText().toString();
                 String ageS = age1.getText().toString();
                 String address1 = address.getText().toString();
                 String email1 = email.getText().toString();
                 String password1 = password.getText().toString();
                 String phno1 = phno.getText().toString();
                String place1 = place.getSelectedItem().toString();

                 int rbcheck = rg.getCheckedRadioButtonId();
                 RadioButton rb = findViewById(rbcheck);
                 String gender = rb.getText().toString();

                 if(cb10.isChecked()){
                     qualification = qualification + ","+cb10.getText().toString();

                 }
                 else if(cb12.isChecked()){
                     qualification = qualification + ","+cb12.getText().toString();

                 }
                 else if(cbbsc.isChecked()){
                     qualification = qualification + ","+cbbsc.getText().toString();

                 }
                 else if(cbbtch.isChecked()){
                     qualification = qualification + ","+ cbbtch.getText().toString();

                 }


                 editr.putString("name",nameS);
                 editr.putString("Password",password1);
                 editr.putString("Age",ageS);
                 editr.putString("Address",address1);
                 editr.putString("Em",email1);
                 editr.putString("Contact",phno1);
                 editr.putString("Place",place1);
                 editr.putString("Gender",gender);
                 editr.putString("Qualification",qualification);
                editr.commit();


                 // Toast.makeText(MainActivity.this, "Name: "+ nameS +" Password: "+ password1 +" Age: "+ageS +" Address: "+address1 +" Email: "+email1 +" Contact: " + phno1 + " Place: " + place1 + " Gender: " + gender +" Qualification: " + qualification + " ", Toast.LENGTH_SHORT).show();

                 Intent  l = new Intent(getApplicationContext(),Login.class);
                 /*l.putExtra("Name",nameS);
                 l.putExtra("Password",password1);
                 l.putExtra("Age",ageS);
                 l.putExtra("Address",address1);
                 l.putExtra("Email",email1);
                 l.putExtra("Contact",phno1);
                 l.putExtra("Place",place1);
                 l.putExtra("Gender",gender);
                 l.putExtra("Qualification",qualification);*/

                 startActivity(l);

             }
         });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.item1:
                Intent i = new Intent(getApplicationContext(),listview.class);
                startActivity(i);
                return true;

            case R.id.item2:
                Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item3:
                Toast.makeText(this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}
