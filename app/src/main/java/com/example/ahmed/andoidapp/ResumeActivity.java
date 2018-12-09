package com.example.ahmed.andoidapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahmed.andoidapp.adapters.ViewPageAdapter;
import com.example.ahmed.andoidapp.fragement.FragementAvis;
import com.example.ahmed.andoidapp.fragement.FragementResume;
import com.example.ahmed.andoidapp.fragement.FragementSeance;

public class ResumeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);


        //fragemnt
        tabLayout=(TabLayout)findViewById(R.id.tablayout_id);
        appBarLayout=(AppBarLayout)findViewById(R.id.appbarlayout_id);
        viewPager=(ViewPager)findViewById(R.id.viewpage_id);
        // Recieve data
        NestedScrollView scrollView = (NestedScrollView) findViewById (R.id.nest_scrollview);
        scrollView.setFillViewport (true);

        Long id=getIntent().getExtras().getLong("id");
        String nom  = getIntent().getExtras().getString("nom");
        String description = getIntent().getExtras().getString("description");
        String prix = getIntent().getExtras().getString("prix") ;
        final String image = getIntent().getExtras().getString("image") ;

        Bundle bundle = new Bundle();
        bundle.putString("edttext", description);
        // set Fragmentclass Arguments
        FragementResume fragobj = new FragementResume();
        fragobj.setArguments(bundle);

        Bundle b = new Bundle();
        b.putString("idff",description);
        FragementSeance f=new FragementSeance();
        f.setArguments(b);

        ViewPageAdapter adapter= new ViewPageAdapter(getSupportFragmentManager());
        adapter.AddFragment(fragobj ,"Resume");
        adapter.AddFragment(new FragementSeance(),"Seance");
        adapter.AddFragment(new FragementAvis(),"Avis");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);








        // ini views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_anime_name);

        //TextView tv_description = findViewById(R.id.aa_description);

        final ImageView img = findViewById(R.id.aa_thumbnail);

        // setting values to each view

        tv_name.setText(nom);

       // tv_description.setText(description);


        collapsingToolbarLayout.setTitle(nom);




        new AsyncTask<Void , Void ,String>(){

            @Override
            protected String doInBackground(Void... voids) {

                return image;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                byte[] decodeString = Base64.decode(s,Base64.DEFAULT);
                Bitmap decode= BitmapFactory.decodeByteArray(decodeString,0,decodeString.length);

                img.setImageBitmap(decode);
            }
        }.execute();






    }
}
