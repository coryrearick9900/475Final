package com.example.a475scienceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a475scienceapplication.sensors.Accelerometer;
import com.example.a475scienceapplication.sensors.GPS;
import com.example.a475scienceapplication.sensors.Sensor;
import com.example.a475scienceapplication.sensors.SoundMeter;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataGathering extends BaseActivity {

    Sensor current;

    boolean toCollect = false;

    Thread DATA_COLLECTION_THREAD;
    Runnable r;

    private long delay;

    ArrayList<DataPoint> datapoints;

    RecyclerView RV;
    View view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_gathering);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nst = extras.getString("SensorType");

            switch (nst) {
                case "Accelerometer":
                    current = new Accelerometer();
                    break;
                case "GPS":
                    current = new GPS();
                    break;
                case "Sound Meter":
                    current = new SoundMeter();
                    break;
            }

            changeAppHeader(nst);

            datapoints = DataPoint.generateTestList();

            RV = findViewById(R.id.dataRecyclerView);

            DataPointAdapter adapter = new DataPointAdapter(datapoints, this);

            RV.setAdapter(adapter);
            RV.setLayoutManager(new LinearLayoutManager(this));
            RV.setHasFixedSize(true);

            Log.d("Test", "About to start the thread");
//            startThread();


            r = () -> {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                Log.d("Test", "Started the thread");

                while (true) {

                    Log.d("Test", "Iterate in the thread");

                    if (toCollect) {
                        String timestamp = dtf.format(now).toString();
                        double collectedDataPoint = current.gatherDataPoint();

                        DataPoint newdp = new DataPoint(timestamp, collectedDataPoint);
                        datapoints.add(newdp);
                    }
                }
            };

            DATA_COLLECTION_THREAD = new Thread(r);
            DATA_COLLECTION_THREAD.start();
        }







    }

    @Override
    protected void onStop() {
        super.onStop();

        DATA_COLLECTION_THREAD = null;

        r = null;
    }

    public void fuckGoBack(View view) {
        Intent i = new Intent(this, SensorsActivity.class);
        startActivity(i);
    }

    public void changeAppHeader(String sensorName) {

        TextView header= findViewById(R.id.sensorName);

        header.setText(sensorName);
    }

    public void startCollection(View view) {
        toCollect = true;
    }

    public void stopCollection(View view) {
        toCollect = false;
    }






















}
