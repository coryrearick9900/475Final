package com.example.a475scienceapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

        ArrayList<DataPoint> newList = new ArrayList<>();
        datapoints = newList;

        RV = findViewById(R.id.recyclerView);

        DataPointAdapter adapter = new DataPointAdapter(datapoints, this);

        RV.setAdapter(adapter);
        RV.setLayoutManager(new LinearLayoutManager(this));
        RV.setHasFixedSize(true);

        Log.d("Test", "Datapoints size: " + datapoints.size());

    }
}
