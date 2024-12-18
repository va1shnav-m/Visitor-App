package com.example.visitorapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    String getFname,getLname,getPurpose,getWhomtomeet;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);

        et1=(EditText) findViewById(R.id.firstname);
        et2=(EditText) findViewById(R.id.lastname);
        et3=(EditText) findViewById(R.id.purpose);
        et4=(EditText) findViewById(R.id.whomtomeet);

        b1=(Button) findViewById(R.id.submit);
        b2=(Button) findViewById(R.id.back);

       b1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               getFname=et1.getText().toString();
               getLname=et2.getText().toString();
               getPurpose=et3.getText().toString();
               getWhomtomeet=et4.getText().toString();
               Toast.makeText(getApplicationContext(),getFname+" "+getLname+" "+getPurpose+" "+getWhomtomeet,Toast.LENGTH_LONG).show();


           }
       });
       b2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent ob=new Intent(getApplicationContext(), MainActivity.class);
               startActivity(ob);
           }
       });












    }
}