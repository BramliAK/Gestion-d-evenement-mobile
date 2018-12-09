package com.example.ahmed.andoidapp.sqlite;

import android.provider.BaseColumns;

/**
 * Created by ahmed on 17/04/2018.
 */

public class DatabaseContract {
    public interface User extends BaseColumns {
        String tableName = "user";
        String columnText = "text";
        String columnTextType = "TEXT";
    }
}
