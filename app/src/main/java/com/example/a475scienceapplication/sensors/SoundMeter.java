package com.example.a475scienceapplication.sensors;

public class SoundMeter extends Sensor {

    public SoundMeter() {
        this.sensorName = "Sound Meter";
    }

    @Override
    public double gatherDataPoint() {
        return 0;
    }
}
