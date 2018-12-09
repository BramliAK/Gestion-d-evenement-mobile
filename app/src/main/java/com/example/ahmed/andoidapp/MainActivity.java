
package com.example.ahmed.andoidapp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ahmed.andoidapp.sqlite.DatabaseOpenHelper;

import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button b1 ;
    private Button b2 ;
    private Button b3 ;
    private Button b4 ;
    private Button b5 ;
    private Button b6 ;
    private ImageButton imageButton1 ;
    private ImageButton imageButton2 ;
    Button button;
    DatabaseOpenHelper myDb;
    TextView textview;
    private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.b1=(Button)findViewById(R.id.button1);
        this.b2=(Button)findViewById(R.id.button2);
        this.b3=(Button)findViewById(R.id.button3);
        this.b4=(Button)findViewById(R.id.button4);
        this.b5=(Button)findViewById(R.id.button5);
        this.b6=(Button)findViewById(R.id.button6);
        button = (Button)findViewById(R.id.button9);
        this.imageButton1=(ImageButton)findViewById(R.id.imageButton2);
        this.imageButton2=(ImageButton)findViewById(R.id.imageButton3);
        //cursor=myDb.getuser();
/*

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://localhost:8081/api/dateevents";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                       Log.i("Response is: ", "gg");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("loooool",error.getMessage());
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);*/



        this.imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Menu.class);

                startActivity(intent);

            }
        });
        this.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,searchActivity.class);

                startActivity(intent);
            }
        });
        this.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        this.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("gg","gg");
                Log.e("lol","looooooooool");


               /* String URL="localhost:8081/api/dateevents";
                JsonObjectRequest objectRequest =new JsonObjectRequest(
                        Request.Method.GET,
                        URL,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.e("rest request",response.toString());
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e("rest request","§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§!");
                            }
                        }
                );*/
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);

                startActivity(intent);
            }
        });
        this.b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);

                startActivity(intent);
            }
        });
        this.b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);

                startActivity(intent);
            }
        });
        this.b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);

                startActivity(intent);
            }
        });
        this.b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);

                startActivity(intent);
            }
        });
        this.b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);

                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DialogFragment dialogfragment = new datepickerClass();

                dialogfragment.show(getFragmentManager(), "DatePickerDialog");

            }
        });





    }
}


