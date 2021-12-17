package com.example.a475scienceapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

/**
 * This is a custom Activity super class to allow for the top bar menu
 * to appear on all activities without having to manually place the code on all the
 * activites
 *
 */
public abstract class BaseActivity extends AppCompatActivity {

    // Inflates the topbar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.topbar_menu, menu);
        return true;
    }

    // Code for each button being pressed
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Once a button is pressed, determine which button it was
        switch(item.getItemId()) {

            // Button for changing from light to dark theme
            case R.id.changeTheme:

                // If dark mode, change to light mode
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    setTheme(R.style.LightTheme);

                    item.setIcon(R.drawable.is_light_mode);
                }
                // if light mode, change to dark mode
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    setTheme(R.style.RedTheme);

                    item.setIcon(R.drawable.is_dark_mode);
                }

                setTheme(R.style.RedTheme);


                break;

            // Mystery button
            case R.id.secret_menu_option:

                // Not sure what this does
                String tutorial = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
                Intent browser = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER);
                browser.setData(Uri.parse(tutorial));
                startActivity(browser);
        }

        // Return out of this method
        return super.onOptionsItemSelected(item);
    }
}
