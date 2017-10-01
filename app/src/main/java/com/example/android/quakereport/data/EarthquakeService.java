package com.example.android.quakereport.data;

import com.example.android.quakereport.entity.EarthquakeQuery;
import com.example.android.quakereport.utils.AppConstants;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by user on 1/10/2017.
 */

public interface EarthquakeService {

    @GET(AppConstants.Network.QUERY)
    Call<EarthquakeQuery> getQuery(@QueryMap Map<String, String> options);
}
