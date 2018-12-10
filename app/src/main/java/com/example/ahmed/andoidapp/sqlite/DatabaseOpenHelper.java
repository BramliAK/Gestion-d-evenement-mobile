package com.example.ahmed.andoidapp.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ahmed on 17/04/2018.
 */

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    public static final int databaseVersion = 1;
    public static final String databaseName = "User.db";
    public DatabaseOpenHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
        SQLiteDatabase db=this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(SQLCreateTableArticles);
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion,
                          int newVersion) {
        database.execSQL(SQLDeleteTableArticles);
        onCreate(database);
    }
    @Override
    public void onDowngrade(SQLiteDatabase database, int oldVersion,
                            int newVersion) {
        onUpgrade(database, oldVersion, newVersion);
    }
    private static final String SQLCreateTableArticles =
            "CREATE TABLE " + DatabaseContract.User.tableName + " (" +
                    DatabaseContract.User._ID + " INTEGER PRIMARY KEY," +
                    DatabaseContract.User.columnText + " " +
                    DatabaseContract.User.columnTextType +

                    " )";
    private static final String SQLDeleteTableArticles =
            "DROP TABLE IF EXISTS " + DatabaseContract.User.tableName;


    public Cursor getuser(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cu=db.rawQuery("select * from "+DatabaseContract.User.tableName,null );
        return cu;
    }
    public Boolean deletetable(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete  from " + DatabaseContract.User.tableName);
        return true;
    }
}


