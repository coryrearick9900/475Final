package com.example.a475scienceapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "users.db";

    private static UserDatabase mUserDatabase;

    public static UserDatabase getInstance(Context context) {
        if (mUserDatabase == null) {
            mUserDatabase = Room.databaseBuilder(context, UserDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
        }

        return mUserDatabase;
    }

    public UserDatabase() {}

    public abstract UserDao userDao();




}
