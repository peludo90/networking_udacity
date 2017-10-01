package com.example.android.quakereport.utils;

/**
 * Created by obed.gonzalez on 03/05/2017.
 */

public class AppConstants {

    final static String TAG = "EarthquakeUdacity";

    public class Network {
        public static final String BASE_URL_EARTHQUAKE = "https://earthquake.usgs.gov/fdsnws/event/1/";
        public static final String QUERY = "query";
        public static final String PARAM_FORMAT = "format";
        public static final String PARAM_START_TIME = "starttime";
        public static final String PARAM_END_TIME = "endtime";
        public static final String PARAM_MIN_MAG = "minmagnitude";




        public static final String PARAM_FORMAT_JSON = "geojson";
    }
}
