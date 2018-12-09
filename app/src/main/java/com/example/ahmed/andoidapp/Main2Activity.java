package com.example.ahmed.andoidapp;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuInflater;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ahmed.andoidapp.adapters.RecyclerViewAdapter;
import com.example.ahmed.andoidapp.model.Dateevents;
import com.example.ahmed.andoidapp.model.Event;
import com.example.ahmed.andoidapp.model.Localisations;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity  {

    private String URL_JSON = "http://192.168.1.6:8081/api/evenementstype/Film";
    private JsonArrayRequest ArrayRequest ;
    private RequestQueue requestQueue ;
    private List<Event> lstAnime = new ArrayList<>();
    private RecyclerView myrv ;
    private String mJSONURLString = "http://192.168.124.2:8081/api/dateevents";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myrv = findViewById(R.id.rv);

        jsoncall();

    }



    private void jsoncall() {
         Log.i("fffff","fffffffffffff");
         ArrayRequest = new JsonArrayRequest(URL_JSON, new Response.Listener<JSONArray>() {
             @Override
             public void onResponse(JSONArray response) {

                 JSONObject jsonObject = null;
                 Log.i("fffff","sssssssssssssssssssssss");
                 Log.i("test", String.valueOf(response.length()));
                 for (int i = 0 ; i<response.length();i++) {

                     try {

                         jsonObject = response.getJSONObject(i);
                         Event event = new Event();

                         event.setNom(jsonObject.getString("nom"));
                         event.setPrix(jsonObject.getString("prix"));
                         event.setDescription(jsonObject.getString("description"));
                         event.setImage(jsonObject.getString("image"));
                         event.setTypeevnet(jsonObject.getString("typeevnet"));
                         event.setDateevents(null);
                         event.setLocalisations(null);
                         //Toast.makeText(MainActivity.this,anime.toString(),Toast.LENGTH_SHORT).show();
                         lstAnime.add(event);
                     }
                     catch (JSONException e) {
                         e.printStackTrace();
                     }
                 }

                 setRvadapter(lstAnime);
             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {

             }
         });


         requestQueue = Volley.newRequestQueue(Main2Activity.this);
         requestQueue.add(ArrayRequest);
     }
    public void setRvadapter (List<Event> lst) {

        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lst) ;
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(myAdapter);




    }


}
