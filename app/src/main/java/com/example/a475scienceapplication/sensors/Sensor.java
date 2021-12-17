package com.example.a475scienceapplication.sensors;

import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import org.json.JSONObject;

import java.util.ArrayList;

public abstract class Sensor implements SensorEventListener {

    String sensorName;
    ArrayList<Float> value;
    SensorManager karen;
    android.hardware.Sensor currentSensor;

    public Sensor() {
        sensorName = "";
    }

    public ArrayList<Float> gatherDataPoint() {
        return null;
    }








}
