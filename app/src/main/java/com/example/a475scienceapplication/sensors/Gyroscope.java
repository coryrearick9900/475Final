package com.example.a475scienceapplication.sensors;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;

import java.util.ArrayList;

public class Gyroscope extends Sensor {



    public Gyroscope(SensorManager newKaren) {
        this.sensorName = "Gyroscope";
        this.karen = newKaren;
        this.currentSensor = newKaren.getDefaultSensor(android.hardware.Sensor.TYPE_GYROSCOPE);
    }

    @Override
    public ArrayList<Float> gatherDataPoint() {
        return null;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        ArrayList<Float> temp = new ArrayList<>();

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
