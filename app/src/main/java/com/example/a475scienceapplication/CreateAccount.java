package com.example.a475scienceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateAccount extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void createUser(View view) {
        EditText usernameBox = (EditText) findViewById(R.id.editTextUsername);
        EditText passwordBox = (EditText) findViewById(R.id.editTextPassword);

        String username = usernameBox.getText().toString();
        String password = passwordBox.getText().toString();

        if (username.equals("")) {
            Toast.makeText(view.getContext(), "Please specify a username", Toast.LENGTH_LONG).show();
        }else if (password.equals("")) {
            Toast.makeText(view.getContext(), "Please specify a password", Toast.LENGTH_LONG).show();
        }else {

            UserDatabase uDb = UserDatabase.getInstance(view.getContext());

            User user = new User(username, password);

            uDb.userDao().InsertUser(user);

            User testUser = uDb.userDao().getUser(user.getUsername(), user.getPassword());

            if (testUser == null) {
                Toast.makeText(view.getContext(), "User could not be created", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(view.getContext(), "User successfully created", Toast.LENGTH_LONG).show();
            }








        }

    }

    public void returnToSignInPage(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }


}
