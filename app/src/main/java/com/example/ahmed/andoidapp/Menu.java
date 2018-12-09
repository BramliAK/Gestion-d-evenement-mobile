package com.example.ahmed.andoidapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ahmed.andoidapp.sqlite.DatabaseContract;
import com.example.ahmed.andoidapp.sqlite.DatabaseOpenHelper;

public class Menu extends AppCompatActivity {

    private Button indentifier;
    private Cursor cursor;

    private DatabaseOpenHelper databaseOpenHelper;
    String text="null";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.indentifier=(Button)findViewById(R.id.button);
        /*cursor=databaseOpenHelper.getuser();
        if(cursor.getCount()==0){
            Log.i("sql","0");
        }else{
            Log.i("sql","1");
        }*/
        //cursor.moveToFirst();
        //int index = cursor.getColumnIndex(DatabaseContract.User.columnText);
       // String text = cursor.getString(index);

        Log.i("token",text);
        this.indentifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,LoginActivity.class);

                startActivity(intent);
            }
        });
    }
}
