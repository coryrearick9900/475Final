package com.example.a475scienceapplication;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class DataPoint {

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



//    public static ArrayList<DataPoint> generateTestList() {
//        ArrayList<DataPoint> newDPlist = new ArrayList<>();
//
//        int min = 0;
//        int max = 100;
//
//        int randomquantity_min = 90;
//        int randomquantity_max = 110;
//
//        Random leRandom = new Random();
//        double randomValue = 0.0;
//        int randomQty = leRandom.nextInt((randomquantity_max - randomquantity_min)) + randomquantity_min;
//        for (int i = 0; i < randomQty; i++) {
//
//            DataPoint newDataPOint = new DataPoint("time" + i, i);
//
//            newDPlist.add(newDataPOint);
//        }
//
//        return newDPlist;
//    }

//    public String printData() {
//        StringBuilder output = new StringBuilder();
//
//        for (int i = 0; i < 2; i++) {
//            output.append(value.get(i)).append(" // ");
//        }   output.append(value.get(2));
//
//        return output.toString();
//    }

}
