package com.example.a475scienceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Create account activity backend
 *
 */

public class CreateAccount extends BaseActivity {

    // Standard onCreate stuff here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    // Method for creating a new user
    public void createUser(View view) {

        // Text boxes for the user to input their information
        EditText usernameBox = (EditText) findViewById(R.id.editTextUsername);
        EditText passwordBox = (EditText) findViewById(R.id.editTextPassword);

        // Strings they input
        String username = usernameBox.getText().toString();
        String password = passwordBox.getText().toString();

        // Cannot create a user with a blank username or blank password
        if (username.equals("")) {
            Toast.makeText(view.getContext(), "Please specify a username", Toast.LENGTH_LONG).show();
        }else if (password.equals("")) {
            Toast.makeText(view.getContext(), "Please specify a password", Toast.LENGTH_LONG).show();
        }else {

            // Get an instance of the database
            UserDatabase uDb = UserDatabase.getInstance(view.getContext());

            // Create a new user to push to the data base with the inputted information
            User user = new User(username, password);

            // Push the new user to the database
            uDb.userDao().InsertUser(user);

            // Pull down a user with the information the user inputted to verify if the user's
            //   information was successfull pushed to the database
            User testUser = uDb.userDao().getUser(user.getUsername(), user.getPassword());

            // Notifies the user if their information was successfully pushed to the database
            if (testUser == null) {
                Toast.makeText(view.getContext(), "User could not be created", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(view.getContext(), "User successfully created", Toast.LENGTH_LONG).show();
            }








        }

    }

    // Returns the user to the sign in page
    public void returnToSignInPage(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }


}
