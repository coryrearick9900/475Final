package com.example.a475scienceapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;

/**
 * Dao for the user database
 *   Includes the queries for pushing to the database and gathering
 *   data from the database
 */
@Dao
public interface UserDao {

    // Returns a user from the database
    @Query("SELECT * FROM User WHERE username = :usr AND password = :pw")
    public User getUser(String usr, String pw);

    // Inserts a user to the database, and if there is a conflict then just abort the query
    @Insert(onConflict = OnConflictStrategy.ABORT)
    public void InsertUser(User newUser);

    // deletes a user from the database
    @Delete
    public void DeleteUser(User deletedUser);



}
