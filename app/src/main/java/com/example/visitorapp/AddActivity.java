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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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

               if(getFname.isEmpty()||getLname.isEmpty()||getPurpose.isEmpty()||getWhomtomeet.isEmpty())
               {

                   Toast.makeText(getApplicationContext(), "All the fields are mandatory", Toast.LENGTH_SHORT).show();

           }
               else
               {


                   callApi();

       }
           }

           private void callApi() {
               String apiUrl="https://log-app-demo-api.onrender.com/addvisitor";
               JSONObject data=new JSONObject();

               try {
                   data.put("firstname",getFname);
                   data.put("lastname",getLname);
                   data.put("purpose",getPurpose);
                   data.put("whomToMeet",getWhomtomeet);
               } catch (JSONException e) {
                   throw new RuntimeException(e);
               }

               JsonObjectRequest request=new JsonObjectRequest(
                       Request.Method.POST,
                       apiUrl,
                       data,
                       response -> Toast.makeText(getApplicationContext(), "Successfully Added", Toast.LENGTH_SHORT).show(),
                       error -> Toast.makeText(getApplicationContext(),"Something Went Wrong!",Toast.LENGTH_LONG).show()

               );
               RequestQueue queue= Volley.newRequestQueue(getApplicationContext());
               queue.add(request);


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













