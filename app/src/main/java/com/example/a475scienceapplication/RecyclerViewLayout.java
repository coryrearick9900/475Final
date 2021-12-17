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

    // Array of datapoints
    ArrayList<DataPoint> datapoints;

    // Reference to the recycler view
    RecyclerView RV;

    // onCreate
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datapoint_layout);

        // Instantiates the array list
        ArrayList<DataPoint> newList = new ArrayList<>();
        datapoints = newList;

        // Sets the reference to the recycler view
        RV = findViewById(R.id.recyclerView);

        // sets the adapter
        DataPointAdapter adapter = new DataPointAdapter(datapoints, this);

        // Sets the adapter for the recycler view
        RV.setAdapter(adapter);
        RV.setLayoutManager(new LinearLayoutManager(this));
        RV.setHasFixedSize(true);

    }
}
