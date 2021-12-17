package com.example.a475scienceapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.WorkSource;
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

    private long delay;

    ArrayList<DataPoint> datapoints;

    TextView theSensorsNameBox;

    RecyclerView RV;
    View view;

    DataPointAdapter adapter;



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
            theSensorsNameBox = (TextView) findViewById(R.id.sensorName);

            changeAppHeader(nst);

            datapoints = new ArrayList<>();

            RV = findViewById(R.id.dataRecyclerView);

            adapter = new DataPointAdapter(datapoints, this);

            RV.setAdapter(adapter);
            RV.setLayoutManager(new LinearLayoutManager(this));
            RV.setHasFixedSize(false);

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

        DateTimeFormatter thedate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime thenow = LocalDateTime.now();

        String timestamp = thedate.format(thenow);
        double datavalue = current.gatherDataPoint();

        DataPoint newdp = new DataPoint(timestamp, datavalue);

        datapoints.add(newdp);

        adapter.notifyItemInserted(datapoints.size());



    }






















}
