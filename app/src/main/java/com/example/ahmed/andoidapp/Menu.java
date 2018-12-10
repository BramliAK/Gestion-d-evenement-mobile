package com.example.ahmed.andoidapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    private Cursor getUser() {
        SQLiteDatabase database = databaseOpenHelper.getReadableDatabase();
        return database.query(DatabaseContract.User.tableName,
                null, null, new String[]{}, null, null, null);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        databaseOpenHelper = new DatabaseOpenHelper(this);
        this.indentifier=(Button)findViewById(R.id.button);
        cursor=getUser();
        if(cursor.getCount()==0){
            Log.i("cc","gg");

            this.indentifier.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(Menu.this,LoginActivity.class);
                    startActivity(intent);
                }
            });
        }else{
            Log.i("cc",String.valueOf(cursor.getCount()));
            this.indentifier.setText("Deconnecter");
            this.indentifier.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    databaseOpenHelper.deletetable();
                    Intent intent=new Intent(Menu.this,MainActivity.class);

                    startActivity(intent);
                }
            });
        }

        Log.i("token",text);

    }
}
