package com.example.a475scienceapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TestUsersPage extends AppCompatActivity implements UserDao{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_list_users);


    }

    // Some variable named i
    private int i = 0;

    // Sets the arraylist to a new array list
    private ArrayList<User> ListOfUsers = new ArrayList<>();

    // Get the user with the specified username and password
    @Override
    public User getUser(String usr, String pw) {
        return null;
    }

    // Inserts a new user to the database
    @Override
    public void InsertUser(User newUser) {

    }

    // Deletes a user from the database
    @Override
    public void DeleteUser(User deletedUser) {

    }

    // Fills the user database with some test users
    //  Used for testing out the database
    public void fillView(View view) {

        LinearLayout placeToAddTexts = (LinearLayout) findViewById(R.id.justUsersList);
        placeToAddTexts.removeAllViews();

        ListOfUsers.clear();

        User user1 = new User("user" + i++, "pass");
        User user2 = new User("user" + i++, "pass");
        User user3 = new User("user" + i++, "pass");

        ListOfUsers.add(user1);
        ListOfUsers.add(user2);
        ListOfUsers.add(user3);


        for (User current : ListOfUsers) {

            String display = "User = " + current.getUsername() + ", " + current.getPassword();



            TextView newTextView = new TextView(view.getContext());
            newTextView.setText(display);
            newTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


            placeToAddTexts.addView(newTextView);



        }
    }
}
