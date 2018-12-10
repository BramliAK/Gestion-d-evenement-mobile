package com.example.ahmed.andoidapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationActivity extends AppCompatActivity {

    private Button submit;
    private EditText username;
    private EditText email;
    private EditText mp;

    public  void test(){}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        submit=(Button)findViewById(R.id.Submit);
        username=(EditText)findViewById(R.id.username);
        email=(EditText)findViewById(R.id.newemail);
        mp=(EditText)findViewById(R.id.motepasse);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                RequestQueue queue = Volley.newRequestQueue(view.getContext());
                JSONObject obj= new JSONObject();
                try {
                    obj.put("login",username.getText().toString());
                    obj.put("email",email.getText().toString());
                    obj.put("password",mp.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.i("object",email.getText().toString());
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                        (Request.Method.POST,"http://192.168.1.8:8081/api/register",obj, new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                Log.i("ddddddddddddddddd","gggggggggggggggg");

                            }
                        }, new Response.ErrorListener() {

                            @SuppressLint("WrongConstant")
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(view.getContext(), "ajout avec succss", 1).show();

                            }
                        });

                queue.add(jsonObjectRequest);

            }
        });
    }
}
