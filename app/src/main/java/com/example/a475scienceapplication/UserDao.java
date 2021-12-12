package com.example.a475scienceapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;

@Dao
public interface UserDao {

//    @Query("SELECT * FROM User")
//    public ArrayList<User> getUsers();

    @Query("SELECT * FROM User WHERE username = :usr AND password = :pw")
    public User getUser(String usr, String pw);

    @Insert(onConflict = OnConflictStrategy.ABORT)
    public void InsertUser(User newUser);

    @Delete
    public void DeleteUser(User deletedUser);

//    @Query("SELECT * FROM User")
//    public ArrayList<User> GetAllUsers();



}
