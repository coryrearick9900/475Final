package com.example.a475scienceapplication.sensors;

import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import java.util.ArrayList;

public class Accelerometer extends Sensor implements SensorEventListener {

    public Accelerometer(SensorManager newKaren) {
        this.karen = newKaren;
        this.currentSensor = newKaren.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public ArrayList<Float> gatherDataPoint() {
        return this.value;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        ArrayList<Float> temp = new ArrayList<>();

        karen.registerListener(this, currentSensor, SensorManager.SENSOR_DELAY_NORMAL);

        for (int i = 0; i < 3; i++) {
            Float tempf = new Float(sensorEvent.values[i]);
            temp.add(tempf);
        }

        this.value = temp;
    }



    @Override
    public void onAccuracyChanged(android.hardware.Sensor sensor, int i) {

    }


}
