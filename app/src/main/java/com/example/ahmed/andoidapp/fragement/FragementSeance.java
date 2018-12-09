package com.example.ahmed.andoidapp.fragement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.ahmed.andoidapp.Main2Activity;
import com.example.ahmed.andoidapp.R;
import com.example.ahmed.andoidapp.adapters.RecycleViewAdapterSeance;
import com.example.ahmed.andoidapp.adapters.RecyclerViewAdapter;
import com.example.ahmed.andoidapp.model.Event;
import com.example.ahmed.andoidapp.model.Localisations;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmed on 24/11/2018.
 */

public class FragementSeance extends Fragment {

    View view;
    private List<Localisations> localisationslist;
    private String URL_JSON1 = "http://192.168.1.6:8081/api/evenementstypeid/2";
    private JsonArrayRequest ArrayRequest1 ;
    private RequestQueue requestQueue1 ;
    private RecyclerView myrv ;
    private TextView textView;

    public FragementSeance(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view=inflater.inflate(R.layout.seance_fragement,container,false);

        myrv= (RecyclerView ) view.findViewById(R.id.crecylceview);
       // textView=(TextView)view.findViewById(R.id.textView9);

        setRvadapter1(localisationslist);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        localisationslist=new ArrayList<>();

        localisationslist.add(new Localisations(1L,"qsd","qsd","aze","aze"));
        jsoncall();

        Log.i("number", String.valueOf(localisationslist.size()));

    }

    private void jsoncall() {
        Log.i("dddddddddd",URL_JSON1);
        ArrayRequest1 = new JsonArrayRequest(URL_JSON1, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for (int i = 0 ; i<response.length();i++) {

                    try {

                        jsonObject = response.getJSONObject(i);
                        Localisations localisation = new Localisations();


                        localisation.setNomemplacement(jsonObject.getString("nomemplacement"));
                        localisation.setEmplacement(jsonObject.getString("emplacement"));
                        localisation.setLongitude(jsonObject.getString("longitude"));
                        localisation.setLatitude(jsonObject.getString("latitude"));
                        localisation.setId(jsonObject.getLong("id"));
                        Log.i("ggggggggg",jsonObject.getString("nomemplacement"));
                        //textView.setText(jsonObject.getString("nomemplacement"));
                        localisationslist.add(localisation);

                        Log.i("number", String.valueOf(localisationslist.size()));
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                //setRvadapter1(localisationslist);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue1 = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue1.add(ArrayRequest1);
    }


    public void setRvadapter1 (List<Localisations> lst) {

        RecycleViewAdapterSeance myAdapter=new RecycleViewAdapterSeance(getContext(),lst);
        myrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrv.setAdapter(myAdapter);




    }



}
