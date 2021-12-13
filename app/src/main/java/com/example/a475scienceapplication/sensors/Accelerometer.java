package com.example.a475scienceapplication.sensors;

public class Accelerometer extends Sensor {

    private static int i;

    @Override
    public double gatherDataPoint() {


        return i++;
    }
}
