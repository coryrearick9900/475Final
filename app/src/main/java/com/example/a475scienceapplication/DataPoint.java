package com.example.a475scienceapplication;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class DataPoint {

    // a data point contains a timestmp and a value
    String timestamp;
    String value;

    public DataPoint(String timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public DataPoint() {
        value = "";
        timestamp = "";
    }



}
