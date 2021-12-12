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

    public void signIn(View view) {
        Log.d("Login", "Entered the method");

        EditText usernameBox = (EditText) findViewById(R.id.editTextUsername);
        EditText passwordBox = (EditText) findViewById(R.id.editTextPassword);

        String username = usernameBox.getText().toString();
        String password = passwordBox.getText().toString();

        if (username.equals("")) {
            Toast.makeText(view.getContext(), "Please enter your username.", Toast.LENGTH_LONG).show();
        }else if (password.equals("")){
            Toast.makeText(view.getContext(), "Please enter your password.", Toast.LENGTH_LONG).show();
        }else {

            Log.d("Login", "Looking for " + username + ", " + password);

            UserDatabase uDb = UserDatabase.getInstance(view.getContext());

            User user = uDb.userDao().getUser(username, password);
            // This statement is failing
            // Not anymore

            if (user == null) {
                Log.d("Login", "user is null");

                Toast.makeText(view.getContext(), "An account with the specified information cannot be found.", Toast.LENGTH_LONG).show();
            } else {

                Log.d("Login", "User's name is " + user.getUsername());

                Intent intent = new Intent(this, SensorsActivity.class);
                startActivity(intent);
            }

        }

    }

    public void goToCreateAccount(View view) {
        Log.d("Creating Account", "Trying to open the activity");

        Intent intent = new Intent(this, CreateAccount.class);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.topbar_menu, menu);


        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch(item.getItemId()) {
//            case R.id.changeTheme:
//
//                Log.d("Changing Themes", "Entered");
//
//                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    setTheme(R.style.LightTheme);
//
//                    item.setIcon(R.drawable.is_light_mode);
//                }else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    setTheme(R.style.RedTheme);
//
//                    item.setIcon(R.drawable.is_dark_mode);
//                }
//
//                setTheme(R.style.RedTheme);
//
//
//                break;
//            case R.id.secret_menu_option:
////                Intent gatheringDataTutorial = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
////                startActivity(gatheringDataTutorial);
//
//                String tutorial = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
//                Intent browser = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER);
//                browser.setData(Uri.parse(tutorial));
//                startActivity(browser);
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
