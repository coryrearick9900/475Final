package com.example.a475scienceapplication;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * User class for each user ot be added to the database
 *
 */
@Entity(indices = {@Index(value = {"username", "password"}, unique = true)})
public class User {

    // An id given to each user
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    // Username for the user
    @NonNull
    @ColumnInfo(name = "username")
    private String username;

    // Password for each user
    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    // Creates a new user for the database
    public User(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setter for all three instance variables:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
