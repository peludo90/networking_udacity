/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.quakereport.adapter.AdapterEarthQuake;
import com.example.android.quakereport.data.EarthquakeService;
import com.example.android.quakereport.entity.EarthQuake;
import com.example.android.quakereport.entity.EarthquakeQuery;
import com.example.android.quakereport.utils.AppConstants;
import com.example.android.quakereport.utils.QueryUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    List<EarthQuake> earthQuakes = null;
    ListView earthquakeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        earthquakeListView = (ListView) findViewById(R.id.list);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConstants.Network.BASE_URL_EARTHQUAKE)
                .addConverterFactory(GsonConverterFactory.create()).build();

        EarthquakeService earthquakeService = retrofit.create(EarthquakeService.class);

        Map<String, String> paramMap = new HashMap<>();

        paramMap.put(AppConstants.Network.PARAM_FORMAT, AppConstants.Network.PARAM_FORMAT_JSON);
        paramMap.put(AppConstants.Network.PARAM_START_TIME, "2017-01-01");
        paramMap.put(AppConstants.Network.PARAM_END_TIME, "2017-03-01");


        Call<EarthquakeQuery> call = earthquakeService.getQuery(paramMap);

        call.enqueue(new Callback<EarthquakeQuery>() {
            @Override
            public void onResponse(Call<EarthquakeQuery> call, Response<EarthquakeQuery> response) {
                if (response != null) {
                    try {
                        earthQuakes = response.body().getFeatures();


                        // Create a new {@link ArrayAdapter} of earthQuakes
                        AdapterEarthQuake adapter = new AdapterEarthQuake(EarthquakeActivity.this, earthQuakes);

                        // Set the adapter on the {@link ListView}
                        // so the list can be populated in the user interface
                        earthquakeListView.setAdapter(adapter);
                    } catch (NullPointerException e) {
                        Log.e(LOG_TAG, "Error", e);
                    }
                }
            }

            @Override
            public void onFailure(Call<EarthquakeQuery> call, Throwable t) {

            }
        });


        // Find a reference to the {@link ListView} in the layout


        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(earthQuakes.get(position).getProperties().getUrl()));
                startActivity(browserIntent);
            }
        });
    }
}
