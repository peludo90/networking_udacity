package com.example.android.quakereport.entity;

import com.example.android.quakereport.utils.DateUtils;

/**
 * Created by obed.gonzalez on 20/04/2017.
 */

public class EarthQuake {

    private String type;
    private Properties properties;
    private Geometry geometry;

    public EarthQuake() {
    }

    public EarthQuake(double magnitude, String location, long date) {
        properties = new Properties();
        properties.setMagnitude(magnitude);
        properties.setLocation(location);
        properties.setDate(date);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getDateFormatted() {
        return DateUtils.getDateString(properties.getDate(), DateUtils.FECHA_DIAMESANIO_12HORA_AMPM);
    }

}
