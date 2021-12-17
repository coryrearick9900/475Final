package com.example.a475scienceapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    UserDatabase theDatabase;

    // Method for the sign in button
    public void signIn(View view) {

        // Text boxes for the user top input their information
        EditText usernameBox = (EditText) findViewById(R.id.editTextUsername);
        EditText passwordBox = (EditText) findViewById(R.id.editTextPassword);

        // Strings they inputted
        String username = usernameBox.getText().toString();
        String password = passwordBox.getText().toString();

        // Error message if either box is empty
        if (username.equals("")) {
            Toast.makeText(view.getContext(), "Please enter your username.", Toast.LENGTH_LONG).show();
        }else if (password.equals("")){
            Toast.makeText(view.getContext(), "Please enter your password.", Toast.LENGTH_LONG).show();
        }else {

            // Adding the data to the database
            UserDatabase uDb = UserDatabase.getInstance(view.getContext());

            User user = uDb.userDao().getUser(username, password);

            // The user's information was not found in the database
            if (user == null) {

                Toast.makeText(view.getContext(), "An account with the specified information cannot be found.", Toast.LENGTH_LONG).show();
            } else {

                // Start the sensor selection activity
                Intent intent = new Intent(this, SensorsActivity.class);
                startActivity(intent);
            }

        }

    }

    // Open the create account screen
    public void goToCreateAccount(View view) {

        // Opens the activity for creating an account
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    // Creates the top bar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.topbar_menu, menu);

        return true;
    }

}
