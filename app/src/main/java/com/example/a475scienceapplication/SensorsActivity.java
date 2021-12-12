package com.example.a475scienceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a475scienceapplication.sensors.Accelerometer;
import com.example.a475scienceapplication.sensors.Sensor;

import java.util.ArrayList;

public class SensorsActivity extends BaseActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
    }

    public SensorsActivity() {

    }

    public void selectSensor(View view) {
        Button clicked = (Button) findViewById(view.getId());
        String sensorName = clicked.getText().toString();

        Log.d("Selection", sensorName + " was selected");


        Intent i = new Intent(this, DataGathering.class);
        i.putExtra("SensorType", sensorName);

        startActivity(i);

    }


}
