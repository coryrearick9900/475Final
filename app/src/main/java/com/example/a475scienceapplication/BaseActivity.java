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

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.topbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.changeTheme:

                Log.d("Changing Themes", "Entered");

                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    setTheme(R.style.LightTheme);

                    item.setIcon(R.drawable.is_light_mode);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    setTheme(R.style.RedTheme);

                    item.setIcon(R.drawable.is_dark_mode);
                }

                setTheme(R.style.RedTheme);


                break;
            case R.id.secret_menu_option:
//                Intent gatheringDataTutorial = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ"));
//                startActivity(gatheringDataTutorial);



                // Opens in browser
                String tutorial = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
                Intent browser = Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER);
                browser.setData(Uri.parse(tutorial));
                startActivity(browser);
        }

        return super.onOptionsItemSelected(item);
    }
}
