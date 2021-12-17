package com.example.a475scienceapplication;

import android.content.Intent;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a475scienceapplication.sensors.Accelerometer;
import com.example.a475scienceapplication.sensors.Sensor;
import com.example.a475scienceapplication.sensors.Gyroscope;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataGathering extends BaseActivity implements SensorEventListener {

    // Array of datapoints collected so far
    ArrayList<DataPoint> datapoints;

    // Text box where the name of the sensor will be displayed
    TextView theSensorsNameBox;

    // Reference to the recycler view in the screen
    RecyclerView RV;

    // Adapter to be used to inflate the recycler view
    DataPointAdapter adapter;

    // The manager that controlls the sensor
    private SensorManager karen;

    // Current sensor
    private android.hardware.Sensor currentSensor;

    // Array of values that the sensor pushes to
    ArrayList<Float> value;


    // onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_gathering);

        // Sets the sensor manager
        karen = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Gathering the extras from the previous activity to know which sensor was selected
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            // Gathers the name of the last sensor
            String nst = extras.getString("SensorType");

            // Sets the sensor manager
            karen = (SensorManager) getSystemService(SENSOR_SERVICE);

            // Determine which sensor the user is using
            switch (nst) {
                case "Accelerometer":
                    currentSensor = karen.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER);
                    break;
                case "Gyroscope":
                    currentSensor = karen.getDefaultSensor(android.hardware.Sensor.TYPE_GYROSCOPE);
                    break;
                case "GPS":
                    Intent i = new Intent(this, MapsActivity.class);
                    startActivity(i);
                    break;
                default:
                    currentSensor = null;
            }
            // Changes the textbox to show the user which sensor they are on
            theSensorsNameBox = (TextView) findViewById(R.id.sensorName);
            changeAppHeader(nst);

            // Creates a new list of datapoints
            datapoints = new ArrayList<>();

            // Sets the recycler view
            RV = findViewById(R.id.dataRecyclerView);

            // sets the adapter for the recycler view
            adapter = new DataPointAdapter(datapoints, this);
            RV.setAdapter(adapter);
            RV.setLayoutManager(new LinearLayoutManager(this));
            RV.setHasFixedSize(false);

            // creates a new arraylist for the values
            value = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                value.add(0.0F);
            }






        }

    }


    // Returns to the sensor selection page
    public void fuckGoBack(View view) {
        Intent i = new Intent(this, SensorsActivity.class);
        startActivity(i);
    }

    // Changes the name of the sensor on the top of the page
    public void changeAppHeader(String sensorName) {

        TextView header= findViewById(R.id.sensorName);
        header.setText(sensorName);
    }

    // Collects a data point from the sensor and adds it to the recycler view
    public void gatherDataPoint(View view) {

        // Gathers the current date and time
        DateTimeFormatter thedate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime thenow = LocalDateTime.now();

        // Creates a time stamp
        String timestamp = thedate.format(thenow);

        // Creates a new datapoint to be added to the recycler view
        DataPoint newdp = new DataPoint(timestamp, printArray(value));

        // adds that datapoint to the datapoints array
        datapoints.add(newdp);

        // tells the recyclerview to update
        adapter.notifyItemInserted(datapoints.size());



    }

    // Event that is called when the sensor is changed
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {


        // Adds the x, y, and z values and pushes them to the values array
        Float x = sensorEvent.values[0];
        Float y = sensorEvent.values[1];
        Float z = sensorEvent.values[2];

        value.add(0, x);
        value.add(1, y);
        value.add(2, z);




    }

    // Not used
    @Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {

    }

    // Prints the datavalues into a string to be displayed in the recyclerview
    public String printArray(ArrayList<Float> input) {

        // Stringbuilder
        StringBuilder bobthebuilder = new StringBuilder();

        bobthebuilder.append(input.get(0));
        bobthebuilder.append(" // ");
        bobthebuilder.append(input.get(0));
        bobthebuilder.append(" // ");
        bobthebuilder.append(input.get(0));


        return bobthebuilder.toString();

    }




}
