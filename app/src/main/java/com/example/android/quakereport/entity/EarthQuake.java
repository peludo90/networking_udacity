package com.example.android.quakereport.entity;

import com.example.android.quakereport.utils.DateUtils;

/**
 * Created by obed.gonzalez on 20/04/2017.
 */

public class Earthquake {

    private double magnitude;
    private String location;
    private long date;

    public Earthquake() {
    }

    public Earthquake(double magnitude, String location, long date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getDateFormatted() {
        return DateUtils.getDateString(date, DateUtils.FECHA_DIAMESANIO_12HORA_AMPM);
    }

    public String getCity() {
        if (location.contains(" of ")) {
            String[] split = location.split(" of ");
            return split[split.length - 1];
        } else {
            return location;
        }

    }
}
