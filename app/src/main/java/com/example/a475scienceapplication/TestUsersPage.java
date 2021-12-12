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

//    private static UserDatabase UserDatabase();

    private int i = 0;

    ArrayList<String> testUsernames = new ArrayList<>();
    ArrayList<String> testPasswrods = new ArrayList<>();

    // Need to place all the users returned from the db into the layout
    public void addUserToView() {

    }

    private ArrayList<User> ListOfUsers = new ArrayList<>();


    @Override
    public User getUser(String usr, String pw) {
        return null;
    }

    @Override
    public void InsertUser(User newUser) {

    }

    @Override
    public void DeleteUser(User deletedUser) {

    }

//    @Override
//    public ArrayList<User> GetAllUsers() {
//        ArrayList<User> newList = new ArrayList<>();
//
//        return newList;
//    }

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

        Log.d("AddItems", "Created Users");


        for (User current : ListOfUsers) {

            Log.d("AddItems", "Loop iteration");

            String display = "User = " + current.getUsername() + ", " + current.getPassword();



            TextView newTextView = new TextView(view.getContext());
            newTextView.setText(display);
            newTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);


            placeToAddTexts.addView(newTextView);

            Log.d("AddItems", "Added an item?");


        }
    }
}
