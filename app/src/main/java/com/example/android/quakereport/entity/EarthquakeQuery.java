package com.example.android.quakereport.entity;

import java.util.List;

/**
 * Created by user on 1/10/2017.
 */

public class EarthquakeQuery {

    private String type;
    private List<EarthQuake> features;

    public EarthquakeQuery() {
    }

    public List<EarthQuake> getFeatures() {
        return features;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFeatures(List<EarthQuake> features) {
        this.features = features;
    }
}
