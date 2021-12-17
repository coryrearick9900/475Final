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

    Sensor current;

    boolean toCollect = false;

    private long delay;

    ArrayList<DataPoint> datapoints;

    TextView theSensorsNameBox;

    RecyclerView RV;
    View view;

    DataPointAdapter adapter;

    private SensorManager karen;
    private android.hardware.Sensor currentSensor;
    ArrayList<Float> value;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_gathering);

        karen = (SensorManager) getSystemService(SENSOR_SERVICE);

        
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nst = extras.getString("SensorType");

            SensorManager theManager = (SensorManager) getSystemService(SENSOR_SERVICE);

            switch (nst) {
                case "Accelerometer":
                    //current = new Accelerometer(theManager);
                    currentSensor = karen.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER);
                    break;
                case "Gyroscope":
                    //current = new Gyroscope(theManager);
                    currentSensor = karen.getDefaultSensor(android.hardware.Sensor.TYPE_GYROSCOPE);
                    break;
                default:
                    currentSensor = null;
            }
            theSensorsNameBox = (TextView) findViewById(R.id.sensorName);

            changeAppHeader(nst);

            datapoints = new ArrayList<>();

            RV = findViewById(R.id.dataRecyclerView);

            adapter = new DataPointAdapter(datapoints, this);

            RV.setAdapter(adapter);
            RV.setLayoutManager(new LinearLayoutManager(this));
            RV.setHasFixedSize(false);

            value = new ArrayList<>();

            for (int i = 0; i < 2; i++) {
                value.add(0.0F);
            }






        }

    }



    public void fuckGoBack(View view) {
        Intent i = new Intent(this, SensorsActivity.class);
        startActivity(i);
    }

    public void changeAppHeader(String sensorName) {

        TextView header= findViewById(R.id.sensorName);

        header.setText(sensorName);
    }

    public void gatherDataPoint(View view) {

        ArrayList<Float> currentDataPoint;

        DateTimeFormatter thedate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime thenow = LocalDateTime.now();

        String timestamp = thedate.format(thenow);

        ArrayList<Float> datavalue = value;
//        double datavalue = current.gatherDataPoint();

        DataPoint newdp = new DataPoint(timestamp, printArray(value));

        datapoints.add(newdp);

        adapter.notifyItemInserted(datapoints.size());



    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        Log.d("Test", "Entered");

        Float x = sensorEvent.values[0];
        Float y = sensorEvent.values[1];
        Float z = sensorEvent.values[2];

        value.add(0, x);
        value.add(1, y);
        value.add(2, z);




    }

    @Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {

    }

    public String printArray(ArrayList<Float> input) {
        StringBuilder bobthebuilder = new StringBuilder();

        bobthebuilder.append(input.get(0));
        bobthebuilder.append(" // ");
        bobthebuilder.append(input.get(0));
        bobthebuilder.append(" // ");
        bobthebuilder.append(input.get(0));


        return bobthebuilder.toString();

    }




}
