package com.example.a475scienceapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Class for the userdatabase
 *
 */
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    // Name of the database
    //   Also kept as constant
    private static final String DATABASE_NAME = "users.db";

    // Instance of the database
    private static UserDatabase mUserDatabase;

    // gets an instance of the database
    public static UserDatabase getInstance(Context context) {
        if (mUserDatabase == null) {
            mUserDatabase = Room.databaseBuilder(context, UserDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }

        return mUserDatabase;
    }

    public UserDatabase() {}

    public abstract UserDao userDao();




}
