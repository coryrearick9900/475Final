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



//    XSSFWorkbook wb = new XSSFWorkbook();

    Thread DATA_COLLECTION_THREAD = new Thread();

    private long delay;

    ArrayList<DataPoint> datapoints;



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
        }

        Log.d("Test", "Entered");



    }

    public void fuckGoBack(View view) {
        Intent i = new Intent(this, SensorsActivity.class);
        startActivity(i);
    }

    public void collectDataPoint() {
        double value = current.gatherDataPoint();
    }

    public void changeAppHeader(String sensorName) {

        TextView header= findViewById(R.id.sensorName);

        header.setText(sensorName);
    }

    public void startCollection(View view) {
        toCollect = true;

        EditText intervalBox = (EditText) findViewById(R.id.intervalPicker);
        delay = Long.parseLong(intervalBox.getText().toString());
    }

    public void stopCollection (View view) {
        toCollect = false;
    }

    Runnable startingCollection = new Runnable() {

        @Override
        public void run() {



            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/M/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            while (toCollect) {

                collectDataPoint();

                try {
                    this.wait(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                double value = current.gatherDataPoint();

                String timestamp = dtf.format((now));
                DataPoint newDataPoint = new DataPoint(timestamp, value);

                datapoints.add(newDataPoint);




            }
        }


    };













}
