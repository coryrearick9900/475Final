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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

import java.util.ArrayList;

public class RecyclerViewLayout extends AppCompatActivity {

    ArrayList<DataPoint> datapoints;

    RecyclerView RV;
    View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datapoint_layout);

        Log.d("Test", "Start");

        datapoints = DataPoint.generateTestList();

        RV = findViewById(R.id.recyclerView);

        DataPointAdapter adapter = new DataPointAdapter(datapoints, this);

        RV.setAdapter(adapter);
        RV.setLayoutManager(new LinearLayoutManager(this));
        RV.setHasFixedSize(true);

        Log.d("Test", "Datapoints size: " + datapoints.size());

    }
}
